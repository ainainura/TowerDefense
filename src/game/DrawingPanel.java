package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

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

import java.awt.Image;

public class DrawingPanel extends JPanel {
	private GameFrame programFrame;
	private ArrowTower tower;
	private Image background;
	private Image hg;
	private Image wave_1;
	private Image arrow_tower;
	private Image frostTowerPic;
	private Image deathTowerPic;
	private Image splashTowerPic;
	private Image soulCollectorPic;
	private Image projectilePic;
	private Image game_over;
	private Image win;
	private int remained_lives;
	boolean inGame = true;

	// array lists of different objects
	private ArrayList<Monster> drawableMonsters = new ArrayList();
	private ArrayList<ArrowTower> drawableTowers = new ArrayList();
	private ArrayList<FrostTower> drawableFrostTowers = new ArrayList();
	private ArrayList<DeathTower> drawableDeathTowers = new ArrayList();
	private ArrayList<SplashTower> drawableSplashTowers = new ArrayList();
	private ArrayList<SoulCollectorTower> drawableSoulCollectorTowers = new ArrayList();
	private ArrayList<ProjectileDeathTower> drawableProjectiles = new ArrayList();
	private ArrayList<ProjectileArrowTower> drawableArrowProjectiles = new ArrayList();
	private ArrayList<ProjectileSplashTower> drawableSplashProjectiles = new ArrayList();
	private ArrayList<ProjectileSoulCollector> drawableSoulCollectorProjectiles = new ArrayList();
	private ArrayList<ProjectileFrostTower> drawableFrostTowerProjectiles = new ArrayList();

	public DrawingPanel() {

		// remained_lives = programFrame.getAnimator().getLives();

		ImageIcon wave1 = new ImageIcon("monster.png");
		wave_1 = wave1.getImage();

		ImageIcon highGround = new ImageIcon("hg.png");
		hg = highGround.getImage();

		ImageIcon at = new ImageIcon("arrow_tower.png");
		arrow_tower = at.getImage();

		ImageIcon bcgrnd = new ImageIcon("background.png");
		background = bcgrnd.getImage();

		ImageIcon ft = new ImageIcon("frostTower.png");
		frostTowerPic = ft.getImage();

		ImageIcon dt = new ImageIcon("deathTower.png");
		deathTowerPic = dt.getImage();

		ImageIcon st = new ImageIcon("splashTower.png");
		splashTowerPic = st.getImage();

		ImageIcon sc = new ImageIcon("soulCollector.png");
		soulCollectorPic = sc.getImage();

		ImageIcon pr = new ImageIcon("projectile.png");
		projectilePic = pr.getImage();

		ImageIcon go = new ImageIcon("gameover.png");
		game_over = go.getImage();

		ImageIcon w = new ImageIcon("you win.png");
		win = w.getImage();

	}

	public void initializeEverything() {

		// Go through and initialize each item
		for (DrawableItem item : this.getDrawableMonsters()) {
			item.initialize();

		}

		for (DrawableItem item : this.getDrawableTowers()) {
			item.initialize();

		}
		for (DrawableItem item : this.getDrawableFrostTowers()) {
			item.initialize();
		}

		for (DrawableItem item : this.getDrawableDeathTowers()) {
			item.initialize();
		}

		for (DrawableItem item : this.getDrawableSoulCollectorTowers()) {
			item.initialize();
		}

		for (DrawableItem item : this.getDrawableProjectiles()) {
			item.initialize();
		}

		for (DrawableItem item : this.getDrawableSplashTowers()) {
			item.initialize();
		}

	}

	public void moveEverythingOneStep() {

		// Go through and move each item one step
		for (DrawableItem item : this.getDrawableMonsters()) {
			item.moveOneStep();

		}

		for (DrawableItem item : this.getDrawableProjectiles()) {
			item.moveOneStep();
		}

		for (DrawableItem item : this.getDrawableArrowProjectiles()) {
			item.moveOneStep();
		}

		for (DrawableItem item : this.getDrawableSplashProjectiles()) {
			item.moveOneStep();
		}

		for (DrawableItem item : this.getDrawableSoulCollectorProjectiles()) {
			item.moveOneStep();
		}

		for (DrawableItem item : this.getDrawableFrostTowerProjectiles()) {
			item.moveOneStep();
		}

	}

	public void paint(Graphics g) {

		if (inGame == true) {
			// This does the default painting first
			super.paint(g);

			g.drawImage(background, 0, 0, 600, 600, this);

			// Labyrinth---------------------------------------------------------------------------------------------------------
			for (int i = 0; i < 5; i++) {
				g.drawImage(hg, i * 600 / 6, 600 / 6, 600 / 6, 600 / 6, this);
			}
			for (int i = 1; i < 6; i++) {
				g.drawImage(hg, i * 600 / 6, 3 * 600 / 6, 600 / 6, 600 / 6,
						this);

			}
			for (int i = 0; i < 5; i++) {
				g.drawImage(hg, i * 600 / 6, 5 * 600 / 6, 600 / 6, 600 / 6,
						this);
			}

			// ---------------------------------------------------------------------------------------------------------------------

			// Go through and draw each item
			for (DrawableItem item : this.getDrawableMonsters()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableTowers()) {
				item.draw(g);
			}
			for (DrawableItem item : this.getDrawableFrostTowers()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableDeathTowers()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableSplashTowers()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableSoulCollectorTowers()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableProjectiles()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableArrowProjectiles()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableSplashProjectiles()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableSoulCollectorProjectiles()) {
				item.draw(g);
			}

			for (DrawableItem item : this.getDrawableFrostTowerProjectiles()) {
				item.draw(g);
			}
		} else if (this.getDrawableMonsters().size() == 0) {
			this.setBackground(Color.WHITE);
			g.drawImage(win, 0, 0, 600, 600, this);

		} else {
			g.drawImage(game_over, 0, 0, 600, 600, this);
		}

	}

	public void addDrawableMonster(Monster item) {
		this.getDrawableMonsters().add(item);
	}

	public void addDrawableTowerArrow(ArrowTower item) {
		this.getDrawableTowers().add(item);
	}

	public void addDrawableTowerFrost(FrostTower item) {
		this.getDrawableFrostTowers().add(item);
	}

	public void addDrawableTowerDeath(DeathTower item) {
		this.getDrawableDeathTowers().add(item);
	}

	public void addDrawableProjectile(ProjectileDeathTower item) {
		this.getDrawableProjectiles().add(item);
	}

	public void addDrawableArrowProjectile(ProjectileArrowTower item) {
		this.getDrawableArrowProjectiles().add(item);
	}

	public void addDrawableFrostTowerProjectile(ProjectileFrostTower item) {
		this.getDrawableFrostTowerProjectiles().add(item);
	}

	public void addDrawableSplashProjectile(ProjectileSplashTower item) {
		this.getDrawableSplashProjectiles().add(item);
	}

	public void addDrawableSoulCollectorProjectile(ProjectileSoulCollector item) {
		this.getDrawableSoulCollectorProjectiles().add(item);
	}

	public ArrayList<ProjectileArrowTower> getDrawableArrowProjectiles() {
		return drawableArrowProjectiles;
	}

	public void setDrawableArrowProjectiles(
			ArrayList<ProjectileArrowTower> drawableArrowProjectiles) {
		this.drawableArrowProjectiles = drawableArrowProjectiles;
	}

	public void addDrawableTowerSplash(SplashTower item) {
		this.getDrawableSplashTowers().add(item);
	}

	public void addDrawableTowerSoulCollector(SoulCollectorTower item) {
		this.getDrawableSoulCollectorTowers().add(item);
	}

	// getters and setters
	public ArrayList<Monster> getDrawableMonsters() {
		return drawableMonsters;
	}

	public int getRemained_lives() {
		return remained_lives;
	}

	public void setRemained_lives(int remained_lives) {
		this.remained_lives = remained_lives;
	}

	public void setDrawableMonster(ArrayList<Monster> drawableItems) {
		this.drawableMonsters = drawableItems;
	}

	public ArrayList<ArrowTower> getDrawableTowers() {
		return drawableTowers;
	}

	public void setDrawableTowers(ArrayList<ArrowTower> drawableTowers) {
		this.drawableTowers = drawableTowers;
	}

	/*
	 * Returns the width of the viewer window
	 */
	public int getWindowWidth() {
		return (int) this.getBounds().getWidth();
	}

	/*
	 * Returns the height of the viewer window
	 */
	public int getWindowHeight() {
		return (int) this.getBounds().getHeight();
	}

	public ArrayList<FrostTower> getDrawableFrostTowers() {
		return drawableFrostTowers;
	}

	public void setDrawableFrostTowers(ArrayList<FrostTower> drawableFrostTowers) {
		this.drawableFrostTowers = drawableFrostTowers;
	}

	public ArrayList<DeathTower> getDrawableDeathTowers() {
		return drawableDeathTowers;
	}

	public void setDrawableDeathTowers(ArrayList<DeathTower> drawableDeathTowers) {
		this.drawableDeathTowers = drawableDeathTowers;
	}

	public ArrayList<SplashTower> getDrawableSplashTowers() {
		return drawableSplashTowers;
	}

	public void setDrawableSplashTowers(
			ArrayList<SplashTower> drawableSplashTowers) {
		this.drawableSplashTowers = drawableSplashTowers;
	}

	public ArrayList<SoulCollectorTower> getDrawableSoulCollectorTowers() {
		return drawableSoulCollectorTowers;
	}

	public ArrayList<ProjectileFrostTower> getDrawableFrostTowerProjectiles() {
		return drawableFrostTowerProjectiles;
	}

	public void setDrawableFrostTowerProjectiles(
			ArrayList<ProjectileFrostTower> drawableFrostTowerProjectiles) {
		this.drawableFrostTowerProjectiles = drawableFrostTowerProjectiles;
	}

	public void setDrawableSoulCollectorTowers(
			ArrayList<SoulCollectorTower> drawableSoulCollectorTowers) {
		this.drawableSoulCollectorTowers = drawableSoulCollectorTowers;
	}

	public ArrayList<ProjectileSoulCollector> getDrawableSoulCollectorProjectiles() {
		return drawableSoulCollectorProjectiles;
	}

	public void setDrawableSoulCollectorProjectiles(
			ArrayList<ProjectileSoulCollector> drawableSoulCollectorProjectiles) {
		this.drawableSoulCollectorProjectiles = drawableSoulCollectorProjectiles;
	}

	public ArrayList<ProjectileDeathTower> getDrawableProjectiles() {
		return drawableProjectiles;
	}

	public void setDrawableProjectiles(
			ArrayList<ProjectileDeathTower> drawableProjectiles) {
		this.drawableProjectiles = drawableProjectiles;
	}

	public ArrayList<ProjectileSplashTower> getDrawableSplashProjectiles() {
		return drawableSplashProjectiles;
	}

	public void setDrawableSplashProjectiles(
			ArrayList<ProjectileSplashTower> drawableSplashProjectiles) {
		this.drawableSplashProjectiles = drawableSplashProjectiles;
	}

	public Image getGame_over() {
		return game_over;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public boolean isInGame() {
		return inGame;
	}

}
