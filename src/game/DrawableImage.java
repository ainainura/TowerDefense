package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class DrawableImage extends DrawableItem {

	private Image image;
	private int width;
	private int height;

	public DrawableImage(DrawingPanel drawArea, String imageFile, int width,
			int height) {

		// Set the drawing panel using DrawableItem's constructor
		super(drawArea);

		// Set the image at imageFile
		Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
		this.setImage(image);

		// Set the height and width of the rendered image (not the image's raw
		// width and height)
		this.setHeight(height);
		this.setWidth(width);
	}

	public void draw(Graphics g) {

		g.drawImage(image, this.getX(), this.getY(), width, height, null);

	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return this.image;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
