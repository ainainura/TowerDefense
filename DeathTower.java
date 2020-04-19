package towers;

import game.DrawableImage;
import game.DrawingPanel;

import java.awt.Image;
import java.awt.Toolkit;

public class DeathTower extends DrawableImage {
	
	private int x;
	private int y;
	
	public int attackSpeed;
	public static int attackCounter= 0;
	
	public int xCoor;
	public int yCoor;
	
	public int cost;
	public int damage;
	public int range;
	public int deathDealingChance; // 5 stands for 5% chance, 20 for 20% and so on

	public DeathTower(DrawingPanel drawArea, String imageFile,
			 int damage, int range, int deathDealingChance,int attackSpeed, int xCoor, int yCoor, int cost) {
		super(drawArea, imageFile, 50, 50);
this.setCost(cost);
		this.setAttackSpeed(attackSpeed);
		this.setDamage(damage);
		this.setDeathDealingChance(deathDealingChance);
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


	public int getDeathDealingChance() {
		return deathDealingChance;
	}

	public void setDeathDealingChance(int deathDealingChance) {
		this.deathDealingChance = deathDealingChance;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public static int getAttackCounter() {
		return attackCounter;
	}

	public static void setAttackCounter(int attackCounter) {
		DeathTower.attackCounter = attackCounter;
	}



	public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
	}


}
