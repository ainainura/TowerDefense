package projectile;

import game.DrawableImage;
import game.DrawingPanel;
import game.Monster;

import java.awt.Graphics;

import towers.FrostTower;

public class ProjectileFrostTower extends DrawableImage {

	private int speed;
	private Monster monster;
	private FrostTower tower;

	private int monsterXCoord;
	private int monsterYCoord;

	public ProjectileFrostTower(DrawingPanel drawArea, String imageFile,
			FrostTower tower, Monster monster, int speed, int width, int height) {

		super(drawArea, imageFile, 15, 15);
		// TODO Auto-generated constructor stub
		this.setMonster(monster);
		this.setSpeed(speed);
		this.setTower(tower);
		this.setMonsterXCoord(this.monster.getX());
		this.setMonsterYCoord(this.monster.getY());

		this.setX(this.tower.getX());
		this.setY(this.tower.getY());
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		int xPos = this.tower.getX();
		int yPos = this.tower.getY();

		// Set the x, y coordinates
		this.setX(xPos);
		this.setY(yPos);
	}

	@Override
	public void moveOneStep() {
		// TODO Auto-generated method stub

		if (this.monster != null) {
			int nextX = this.tower.getX();
			int nextY = this.tower.getY();

			nextX = this.getX() + ((this.monster.getX() - this.tower.getX()))
					/ this.speed;
			nextY = this.getY() + (this.monster.getY() - this.tower.getY())
					/ this.speed;

			this.setX(nextX);
			this.setY(nextY);

			this.setMonsterXCoord(this.monster.getX());
			this.setMonsterYCoord(this.monster.getY());
		} else {
			int nextX = 0;
			int nextY = 0;

			nextX = (this.getX() + (monsterXCoord - this.tower.getX())
					/ this.speed);
			nextY = (this.getY() + (monsterYCoord - this.tower.getY()
					/ this.speed));

			this.setX(nextX);
			this.setY(nextY);
		}

	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public FrostTower getTower() {
		return tower;
	}

	public void setTower(FrostTower tower) {
		this.tower = tower;
	}

	public int getMonsterXCoord() {
		return monsterXCoord;
	}

	public void setMonsterXCoord(int monsterXCoord) {
		this.monsterXCoord = monsterXCoord;
	}

	public int getMonsterYCoord() {
		return monsterYCoord;
	}

	public void setMonsterYCoord(int monsterYCoord) {
		this.monsterYCoord = monsterYCoord;
	}

}
