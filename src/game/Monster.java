package game;

import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;
import java.util.Random;

public class Monster extends DrawableImage {

	private int speed;
	private final int SPAWN_X = WINDOW_WIDTH / 30;
	private final int SPAWN_Y = WINDOW_WIDTH / 15;
	private final int CREEP_WIDTH = WINDOW_WIDTH / 30;
	public final static int WINDOW_WIDTH = 600;
	public final static int WINDOW_HEIGHT = 600;
	private int HealthPoints;
	private int ArmorPoints;
	private boolean frozen = false;
	private boolean attackedByFrost = false;

	public Monster(DrawingPanel drawArea, String imageFile, int speed,
			int HealthPoints, int ArmorPoints) {
		super(drawArea, imageFile, 20, 20);
		// TODO Auto-generated constructor stub
		this.setSpeed(speed);
		this.setHealthPoints(HealthPoints);
		this.setArmorPoints(ArmorPoints);
	}

	public void initialize() {

		int xPos = SPAWN_X;
		int yPos = SPAWN_Y;

		// Set the x, y coordinates
		this.setX(xPos);
		this.setY(yPos);
	}

	public void moveOneStep() {

		int nextX = 0;
		int nextY = SPAWN_Y;

		// Moves the fish forward this.getSpeed() pixels in the right or
		// left direction, but if it gets to the edge, reverses the direction of
		// the fish
		if (this.getX() < (WINDOW_WIDTH - WINDOW_WIDTH / 30)
				&& this.getY() == SPAWN_Y) {
			nextX = this.getX() + speed;
			nextY = this.getY();
		}

		if (this.getX() >= WINDOW_WIDTH - 2 * WINDOW_WIDTH / 30
				&& this.getY() >= SPAWN_Y
				&& this.getY() <= (WINDOW_WIDTH / 3 + WINDOW_WIDTH / 20)) {
			nextX = this.getX();
			nextY = this.getY() + speed;
		}

		if (this.getX() > SPAWN_X
				&& this.getY() >= WINDOW_WIDTH / 3 + WINDOW_WIDTH / 20) {
			nextX = this.getX() - speed;
			nextY = this.getY();
		}

		if (this.getX() <= SPAWN_X
				&& this.getY() >= WINDOW_WIDTH / 3 + WINDOW_WIDTH / 20
				&& this.getY() <= WINDOW_WIDTH / 3 + WINDOW_WIDTH * 4 / 10) {
			nextY = this.getY() + speed;
			nextX = this.getX();
		}

		if (this.getX() < (WINDOW_WIDTH - WINDOW_WIDTH / 30)
				&& this.getY() >= WINDOW_WIDTH / 3 + WINDOW_WIDTH * 4 / 10) {
			nextX = this.getX() + speed;
			nextY = this.getY();
		}

		if (this.getX() >= (WINDOW_WIDTH - 3 * WINDOW_WIDTH / 30)
				&& this.getY() >= WINDOW_WIDTH / 3 + WINDOW_WIDTH * 4 / 10) {
			nextX = this.getX();
			nextY = this.getY() + speed;
		}

		this.setX(nextX);
		this.setY(nextY);
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public int getHealthPoints() {
		return HealthPoints;
	}

	public void setHealthPoints(int hP) {
		HealthPoints = hP;
	}

	public int getArmorPoints() {
		return ArmorPoints;
	}

	public void setArmorPoints(int armorPoints) {
		ArmorPoints = armorPoints;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	public boolean isAttackedByFrost() {
		return attackedByFrost;
	}

	public void setAttackedByFrost(boolean attackedByFrost) {
		this.attackedByFrost = attackedByFrost;
	}

}
