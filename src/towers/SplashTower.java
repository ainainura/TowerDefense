package towers;

import game.DrawableImage;
import game.DrawingPanel;

import java.awt.Image;
import java.awt.Toolkit;

public class SplashTower extends DrawableImage {

	private int x;
	private int y;

	public int cost;
	public int xCoor;
	public int yCoor;
	public static int attackCounter = 0;

	public int damage;
	public int range;
	public int splashRange;
	public int splashPercentage;

	public SplashTower(DrawingPanel drawArea, String imageFile, int damage,
			int range, int splashRange, int splashPercentage, int xCoor,
			int yCoor, int cost) {
		super(drawArea, imageFile, 50, 50);

		this.setCost(cost);
		this.setDamage(damage);
		this.setSplashRange(splashRange);
		this.setRange(range);
		this.setSplashPercentage(splashPercentage);

		this.setX(xCoor);
		this.setY(yCoor);

	}

	/*
	 * createImage(String) creates an Image object from the given file
	 */
	private static Image createImage(String imageFile) {

		return Toolkit.getDefaultToolkit().getImage(imageFile);
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

	public int getSplashRange() {
		return splashRange;
	}

	public void setSplashRange(int splashRange) {
		this.splashRange = splashRange;
	}

	public int getSplashPercentage() {
		return splashPercentage;
	}

	public void setSplashPercentage(int splashPercentage) {
		this.splashPercentage = splashPercentage;
	}

	public static int getAttackCounter() {
		return attackCounter;
	}

	public static void setAttackCounter(int attackCounter) {
		SplashTower.attackCounter = attackCounter;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
