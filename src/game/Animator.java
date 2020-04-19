package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import projectile.ProjectileArrowTower;
import projectile.ProjectileDeathTower;
import projectile.ProjectileFrostTower;
import projectile.ProjectileSoulCollector;
import projectile.ProjectileSplashTower;

import towers.ArrowTower;
import towers.DeathTower;
import towers.FrostTower;
import towers.SoulCollectorTower;
import towers.SplashTower;

public class Animator implements ActionListener {

	private GameFrame GameFrame;
	public static Integer lives = 10;
	public static Integer coins = 3010;
	private static int counter;
	private static int monsterCounter;
	private static int counterForDeathTower;
	private static int counterForArrowTower;
	private static int counterForSplashTower;
	private static int counterForSoulCollectorTower;
	private static int counterForFrostTower;

	public Animator(GameFrame GameFrame) {
		this.setGameFrame(GameFrame);
	}

	public void actionPerformed(ActionEvent arg0) {

		// Get the drawing panel from the GameFrame
		GameFrame GameFrame = this.getGameFrame();
		DrawingPanel dPanel = GameFrame.getDrawingPanel();

		// Move everything one step, and repaint everything

		// ------------------------------- spawnMonster
		// ----------------------------------------------------------------
		if (counter % 10 == 0) {
			Random rand = new Random();

			int spd = rand.nextInt(5) + 5;
			if (dPanel.getDrawableMonsters().size() <= 32
					&& monsterCounter <= 32) {
				dPanel.addDrawableMonster(new Monster(dPanel, "monster.png", 4,
						100 + 2 * counter, 4));
				monsterCounter++;
			}

		}

		// ----------------------------------- checkShooting for Arrow
		// Towers-------------------------------------------------------
		for (ArrowTower tower : dPanel.getDrawableTowers()) {

			tower.setAttackCounter(tower.getAttackCounter() + 1);

			if (tower.getAttackCounter() % tower.getAttack_speed() == 0) {

				for (Monster monster : dPanel.getDrawableMonsters()) {
					if (Math.pow((tower.getX() - monster.getX()), 2)
							+ Math.pow((tower.getY() - monster.getY()), 2) <= Math
								.pow((tower.getRange()), 2)) {

						dPanel.addDrawableArrowProjectile(new ProjectileArrowTower(
								dPanel, "arrowprojectile1.png", tower, monster,
								8, 10, 10));

						if (monster.getHealthPoints() <= 0) {
							dPanel.getDrawableMonsters().remove(monster);
						}

						break; // so it will not attack multiple targets at one
								// step
					}

				}
			}
		}

		// ------------------------------------checkShooting for frost Towers
		// -----------------------------------------

		for (FrostTower tower : dPanel.getDrawableFrostTowers()) {

			boolean thisFrostAttackedSmb = false;
			tower.setAttackCounter(tower.getAttackCounter() + 1);

			if (tower.getAttackCounter() % tower.getAttack_speed() == 0) {

				for (Monster monster : dPanel.getDrawableMonsters()) {

					if (!monster.isAttackedByFrost()) { // it will not attack
														// same target multiple
														// times, it will slow
														// down different
														// targets

						if (Math.pow((tower.getX() - monster.getX()), 2)
								+ Math.pow((tower.getY() - monster.getY()), 2) <= Math
									.pow((tower.getRange()), 2)) {

							// monster.setHealthPoints(monster.getHealthPoints()
							// - (tower.getDamage() -
							// monster.getArmorPoints()));
							dPanel.addDrawableFrostTowerProjectile(new ProjectileFrostTower(
									dPanel, "frostprojectile.png", tower,
									monster, 8, 10, 10));
							// freezing

							if (!monster.isFrozen()) { // this tower will not
														// slow monster more
														// than 1 time

								if (monster.getSpeed() - tower.getFrostRate() >= 0) { // so
																						// the
																						// speed
																						// will
																						// not
																						// be
																						// negative
									monster.setSpeed(monster.getSpeed()
											- tower.getFrostRate());
								} else {
									monster.setSpeed(0); // monster will stop at
															// least
								}

								if (monster.getHealthPoints() <= 0) {
									dPanel.getDrawableMonsters()
											.remove(monster);
								}

								monster.setFrozen(true); // now this monster is
															// marked as frozen
							}

							thisFrostAttackedSmb = true;
							monster.setAttackedByFrost(true); // now this
																// monster is
																// marked as
																// attacked by
																// frost
							break; // so it will not attack multiple targets at
									// one step
						}

					}
				}

				// the next chunk is for the case when frost tower did not
				// attacked anybody,
				// because monsters were previously attacked by frost tower

				if (!thisFrostAttackedSmb) {
					for (Monster monster : dPanel.getDrawableMonsters()) {
						if (Math.pow((tower.getX() - monster.getX()), 2)
								+ Math.pow((tower.getY() - monster.getY()), 2) <= Math
									.pow((tower.getRange()), 2)) {

							dPanel.addDrawableFrostTowerProjectile(new ProjectileFrostTower(
									dPanel, "frostprojectile.png", tower,
									monster, 8, 10, 10));

							if (monster.getHealthPoints() <= 0) {
								dPanel.getDrawableMonsters().remove(monster);
							}

							break; // so it will not attack multiple targets at
									// one step
						}

					}

				}
			}

		}

		// --------------------------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------

		// ----------------------------- checkShooting for Death Tower
		// -------------------------------------------

		for (DeathTower tower : dPanel.getDrawableDeathTowers()) {
			tower.setAttackCounter(tower.getAttackCounter() + 1);

			if (tower.getAttackCounter() % tower.getAttackSpeed() == 0) {

				for (Monster monster : dPanel.getDrawableMonsters()) {
					if (Math.pow((tower.getX() - monster.getX()), 2)
							+ Math.pow((tower.getY() - monster.getY()), 2) <= Math
								.pow((tower.getRange()), 2)) {

						dPanel.addDrawableProjectile(new ProjectileDeathTower(
								dPanel, "projectile.png", tower, monster, 8,
								10, 10));

						if (monster.getHealthPoints() <= 0) {

							dPanel.getDrawableMonsters().remove(monster);
						}

						// ----- death dealing ---------

						Random rand = new Random();
						int deathRand = rand.nextInt(100) + 1;
						int deathChance = (int) (100 / tower
								.getDeathDealingChance());

						if (deathRand % deathChance == 0) {

							dPanel.getDrawableMonsters().remove(monster);
						}

						break; // so it will not attack multiple targets at one
								// step
					}

				}
			}
		}

		// -----------------------------------------------------------------------------------------------------

		// ----------------------------- checkShooting for Splash Tower
		// -------------------------------------------

		Monster tempDeadOne = null;
		for (SplashTower tower : dPanel.getDrawableSplashTowers()) {

			// tower.setAttackCounter(tower.getAttackCounter()+1);
			// if (tower.getAttackCounter()%1 == 0){
			// if (tower.getAttackCounter()%tower.getAttack_speed() == 0) {
			for (Monster monster : dPanel.getDrawableMonsters()) {
				if (Math.pow((tower.getX() - monster.getX()), 2)
						+ Math.pow((tower.getY() - monster.getY()), 2) <= Math
							.pow((tower.getRange()), 2)) {

					dPanel.addDrawableSplashProjectile(new ProjectileSplashTower(
							dPanel, "splashprojectile.png", tower, monster, 8,
							10, 10));

					// /////////////////////////////nearly
					// monster////////////////////////////////////////////////
					for (Monster nearlyMonster : dPanel.getDrawableMonsters()) {
						if (monster != nearlyMonster) {
							if (Math.pow(
									(monster.getX() - nearlyMonster.getX()), 2)
									+ Math.pow((monster.getY() - nearlyMonster
											.getY()), 2) <= Math.pow(
									(tower.getSplashRange()), 2)) {
								// dPanel.addDrawableSplashProjectile(new
								// ProjectileSplashTower(dPanel,"splashprojectile.png",
								// tower, monster, 8, 10, 10));
								// damage dealt by splash part is pure
								// damage(i.e. is not reduced by armor)
								nearlyMonster
										.setHealthPoints(nearlyMonster
												.getHealthPoints()
												- (int) (tower.getDamage()
														* tower.getSplashPercentage() / 100));

								// death check----------------
								if (nearlyMonster.getHealthPoints() <= 0) {
									tempDeadOne = nearlyMonster;
								}
							}

						}
					}

					// //////////////////////////////////////////////////////////////////////////////////////////////

					if (monster.getHealthPoints() <= 0) {
						dPanel.getDrawableMonsters().remove(monster);
					}

					dPanel.getDrawableMonsters().remove(tempDeadOne);

					break; // so it will not attack multiple targets at one step
				}

			}
		}

		// ---------------------------------------------------check for removing
		// splash projectiles -------------------------//
		ArrayList<ProjectileSplashTower> deadSplashProjectiles = new ArrayList();
		for (ProjectileSplashTower projectile : dPanel
				.getDrawableSplashProjectiles()) {

			if (Math.pow(projectile.getX() - projectile.getMonster().getX(), 2)
					+ Math.pow(projectile.getY()
							- projectile.getMonster().getY(), 2) <= 525) {
				deadSplashProjectiles.add(projectile);
				projectile
						.getMonster()
						.setHealthPoints(
								projectile.getMonster().getHealthPoints()
										- (projectile.getTower().getDamage() - projectile
												.getMonster().getArmorPoints()));

			}

			if (projectile.getMonster().getHealthPoints() <= 0) {
				dPanel.getDrawableMonsters().remove(projectile.getMonster());
			}
		}

		for (ProjectileSplashTower deadProjectile : deadSplashProjectiles) {
			dPanel.getDrawableSplashProjectiles().remove(deadProjectile);
		}

		// -----------------------------------------------------------------------------------------------------

		// ----------------------------------- checkShooting for Soul Collector
		// Towers-------------------------------------------------------
		for (SoulCollectorTower tower : dPanel.getDrawableSoulCollectorTowers()) {
			tower.setAttackCounter(tower.getAttackCounter() + 1);

			if (tower.getAttackCounter() % 5 == 0) {
				for (Monster monster : dPanel.getDrawableMonsters()) {
					if (Math.pow((tower.getX() - monster.getX()), 2)
							+ Math.pow((tower.getY() - monster.getY()), 2) <= Math
								.pow((tower.getRange()), 2)) {
						// monster.setHealthPoints(monster.getHealthPoints() - (
						// (tower.getDamage()+tower.getNumberOfSouls()*tower.getDamagePerSoul())
						// - monster.getArmorPoints()));
						dPanel.addDrawableSoulCollectorProjectile(new ProjectileSoulCollector(
								dPanel, "soulprojectile.png", tower, monster,
								8, 10, 10));

						if (monster.getHealthPoints() <= 0) {
							dPanel.getDrawableMonsters().remove(monster);
							tower.setNumberOfSouls(tower.getNumberOfSouls() + 1);
						}

						break; // so it will not attack multiple targets at one
								// step
					}
				}
			}
		}

		// ------------------------------------------------------ check for
		// removing death projectiles -------------------------------------

		ArrayList<ProjectileDeathTower> deadProjectiles = new ArrayList();
		for (ProjectileDeathTower projectile : dPanel.getDrawableProjectiles()) {

			if (Math.pow(projectile.getX() - projectile.getMonster().getX(), 2)
					+ Math.pow(projectile.getY()
							- projectile.getMonster().getY(), 2) <= 525) {
				deadProjectiles.add(projectile);
				projectile.getMonster().setHealthPoints(
						projectile.getMonster().getHealthPoints()
								- projectile.getTower().getDamage());
			}

			if (projectile.getMonster().getHealthPoints() <= 0) {
				dPanel.getDrawableMonsters().remove(projectile.getMonster());
			}
		}

		for (ProjectileDeathTower deadProjectile : deadProjectiles) {
			dPanel.getDrawableProjectiles().remove(deadProjectile);
		}

		// ------------------------------------------------ check for removing
		// arrow projectiles ---------------------------------------//

		ArrayList<ProjectileArrowTower> deadArrowProjectiles = new ArrayList();
		for (ProjectileArrowTower projectile : dPanel
				.getDrawableArrowProjectiles()) {

			if (Math.pow(projectile.getX() - projectile.getMonster().getX(), 2)
					+ Math.pow(projectile.getY()
							- projectile.getMonster().getY(), 2) <= 525) {
				deadArrowProjectiles.add(projectile);
				projectile.getMonster().setHealthPoints(
						projectile.getMonster().getHealthPoints()
								- projectile.getTower().getDamage());
			}

			if (projectile.getMonster().getHealthPoints() <= 0) {
				dPanel.getDrawableMonsters().remove(projectile.getMonster());
			}
		}

		for (ProjectileArrowTower deadProjectile : deadArrowProjectiles) {
			dPanel.getDrawableArrowProjectiles().remove(deadProjectile);
		}

		// -------------------------------------------------check for removing
		// soul collector projectiles-------------------//

		ArrayList<ProjectileSoulCollector> deadSoulCollectorProjectiles = new ArrayList();
		for (ProjectileSoulCollector projectile : dPanel
				.getDrawableSoulCollectorProjectiles()) {

			if (Math.pow(projectile.getX() - projectile.getMonster().getX(), 2)
					+ Math.pow(projectile.getY()
							- projectile.getMonster().getY(), 2) <= 525) {
				deadSoulCollectorProjectiles.add(projectile);
				// projectile.getMonster().setHealthPoints(projectile.getMonster().getHealthPoints()
				// - projectile.getTower().getDamage());
				projectile
						.getMonster()
						.setHealthPoints(
								projectile.getMonster().getHealthPoints()
										- ((projectile.getTower().getDamage() + projectile
												.getTower().getNumberOfSouls()
												* projectile.getTower()
														.getDamagePerSoul()) - projectile
												.getMonster().getArmorPoints()));
			}

			if (projectile.getMonster().getHealthPoints() <= 0) {
				dPanel.getDrawableMonsters().remove(projectile.getMonster());
			}
		}

		for (ProjectileSoulCollector deadProjectile : deadSoulCollectorProjectiles) {
			dPanel.getDrawableSoulCollectorProjectiles().remove(deadProjectile);
		}

		// ------------------------------------------------------ check for
		// removing frost projectiles -------------------------------------

		ArrayList<ProjectileFrostTower> deadFrostProjectiles = new ArrayList();
		for (ProjectileFrostTower projectile : dPanel
				.getDrawableFrostTowerProjectiles()) {

			if (Math.pow(projectile.getX() - projectile.getMonster().getX(), 2)
					+ Math.pow(projectile.getY()
							- projectile.getMonster().getY(), 2) <= 525) {
				deadFrostProjectiles.add(projectile);
				// projectile.getMonster().setHealthPoints(projectile.getMonster().getHealthPoints()
				// - projectile.getTower().getDamage());
				projectile
						.getMonster()
						.setHealthPoints(
								projectile.getMonster().getHealthPoints()
										- (projectile.getTower().getDamage() - projectile
												.getMonster().getArmorPoints()));
			}

			if (projectile.getMonster().getHealthPoints() <= 0) {
				dPanel.getDrawableMonsters().remove(projectile.getMonster());
			}
		}

		for (ProjectileFrostTower deadProjectile : deadFrostProjectiles) {
			dPanel.getDrawableFrostTowerProjectiles().remove(deadProjectile);
		}

		// --------------------------------------------------checking lives
		// -------------------------------//
		HashSet<Monster> passedMonsters = new HashSet<Monster>();
		for (Monster monster : dPanel.getDrawableMonsters()) {
			if (monster.getX() > 530 && monster.getY() > 595) {
				passedMonsters.add(monster);
				lives = 10 - passedMonsters.size();
			}
		}

		if (passedMonsters.size() == 10) {

			dPanel.setInGame(false);
		}

		if (dPanel.getDrawableMonsters().size() == 0) {
			dPanel.setInGame(false);

		}

		if (dPanel.isInGame() == false) {
			GameFrame.getTimer().stop();
		}

		// printing out number of lives and coins

		GameFrame.getCoins().setText(coins.toString());
		GameFrame.getTowerDescription().setText(GameFrame.getDescription());
		GameFrame.getProgressBar().setString(lives.toString());

		System.out.println(coins);
		System.out.println(GameFrame.getDescription());
		// System.out.println(passedMonsters.size());

		// ---------------------------------------------------------------------------------------------------------
		// ---------------------------- moveEverything
		// ----------------------------------------------------------------
		dPanel.moveEverythingOneStep();

		// ------------------------------------------------------------------------------------------------------------

		dPanel.repaint();

		counter++;

	}

	public GameFrame getGameFrame() {
		return GameFrame;
	}

	public void setGameFrame(GameFrame GameFrame) {
		this.GameFrame = GameFrame;
	}

	public static int getLives() {
		return lives;
	}

	public static void setLives(int lives) {
		Animator.lives = lives;
	}

	public static int getCoins() {
		return coins;
	}

	public static void setCoins(int coins) {
		Animator.coins = coins;
	}

}