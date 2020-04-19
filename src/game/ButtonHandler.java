package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ButtonHandler extends DrawingPanel implements ActionListener {

	private GameFrame frame;
	public int tower_id = -1;

	// Constructor
	public ButtonHandler(GameFrame frame) {
		this.setFrame(frame);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("start")) {
			frame.getTimer().start();
		}

		if (e.getActionCommand().equals("tower1")) {
			tower_id = 1;
		}

		if (e.getActionCommand().equals("tower2")) {
			tower_id = 2;

		}

		if (e.getActionCommand().equals("tower3")) {
			tower_id = 3;
		}

		if (e.getActionCommand().equals("tower4")) {
			tower_id = 4;
		}

		if (e.getActionCommand().equals("tower5")) {
			tower_id = 5;
		}

	}

	// Getters and setters
	public GameFrame getFrame() {
		return frame;
	}

	public void setFrame(GameFrame frame) {
		this.frame = frame;
	}

	public int getTower_id() {
		return tower_id;
	}

	public void setTower_id(int tower_id) {
		this.tower_id = tower_id;
	}

}
