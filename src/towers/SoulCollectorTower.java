package towers;

import game.DrawableImage;
import game.DrawingPanel;

import java.awt.Image;
import java.awt.Toolkit;

public class SoulCollectorTower extends DrawableImage {

	private int x;
	private int y;

	public static final Image TOWER1 = createImage("tower1.png");
	public static final Image TOWER2 = createImage("tower2.png");
	public static final Image TOWER3 = createImage("tower3.png");

	public int cost;
	public int xCoor;
	public int yCoor;
	public int attack_speed;
	public int damage;
	public int range;
	public int numberOfSouls = 0;
	public int damagePerSoul;
	public static int attackCounter = 0;

	public SoulCollectorTower(DrawingPanel drawArea, String imageFile,
			int attack_speed, int damage, int range, int damagePerSoul,
			int xCoor, int yCoor, int cost) {
		super(drawArea, imageFile, 50, 50);
		this.setCost(cost);
		this.setAttack_speed(attack_speed);
		this.setDamage(damage);
		this.setRange(range);
		this.setX(xCoor);
		this.setY(yCoor);
		this.setDamagePerSoul(damagePerSoul);

	}

	/*
	 * createImage(String) creates an Image object from the given file
	 */
	private static Image createImage(String imageFile) {

		return Toolkit.getDefaultToolkit().getImage(imageFile);
	}

	public int getAttack_speed() {
		return attack_speed;
	}

	public void setAttack_speed(int attack_speed) {
		this.attack_speed = attack_speed;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void initialize() {
		this.setX(xCoor);
		this.setY(yCoor);
	}

	public void moveOneStep() {

	}

	public int getWidth() {
		return this.getImage().getWidth(null);

	}

	public int getHeight() {
		return this.getImage().getHeight(null);
	}

	void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getNumberOfSouls() {
		return numberOfSouls;
	}

	public void setNumberOfSouls(int numberOfSouls) {
		this.numberOfSouls = numberOfSouls;
	}

	public int getDamagePerSoul() {
		return damagePerSoul;
	}

	public void setDamagePerSoul(int damagePerSoul) {
		this.damagePerSoul = damagePerSoul;
	}

	public static int getAttackCounter() {
		return attackCounter;
	}

	public static void setAttackCounter(int attackCounter) {
		SoulCollectorTower.attackCounter = attackCounter;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
