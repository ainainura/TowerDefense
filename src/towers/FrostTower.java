package towers;

import game.DrawableImage;
import game.DrawingPanel;

import java.awt.Image;
import java.awt.Toolkit;

public class FrostTower extends DrawableImage {

	private int x;
	private int y;

	public int xCoor;
	public int yCoor;
	public int attack_speed;
	public int cost;
	public int damage;
	public int range;
	public int frostRate;
	public static int attackCounter = 0;

	public FrostTower(DrawingPanel drawArea, String imageFile,
			int attack_speed, int damage, int range, int frostRate, int xCoor,
			int yCoor, int cost) {
		super(drawArea, imageFile, 50, 50);
		this.setCost(cost);
		this.setAttack_speed(attack_speed);
		this.setDamage(damage);
		this.setFrostRate(frostRate);
		this.setRange(range);
		this.setX(xCoor);
		this.setY(yCoor);

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

	public int getFrostRate() {
		return frostRate;
	}

	public void setFrostRate(int frostRate) {
		this.frostRate = frostRate;
	}

	public static int getAttackCounter() {
		return attackCounter;
	}

	public static void setAttackCounter(int attackCounter) {
		FrostTower.attackCounter = attackCounter;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
