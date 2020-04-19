package game;

import java.awt.event.*;

import towers.ArrowTower;
import towers.DeathTower;
import towers.FrostTower;
import towers.SoulCollectorTower;
import towers.SplashTower;

public class MouseHandler implements MouseListener {
	private GameFrame frame;
	public int mouse_x = 300;
	public int mouse_y = 300;
	private int tId;
	public String towerDescription;
	private String towerDescription1 = "this is arrow tower.";

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mouse_x = arg0.getX();
		mouse_y = (arg0.getY() - 25);
		if ((mouse_x >= 0 && mouse_x <= 500 && mouse_y <= 200 && mouse_y >= 100)
				|| (mouse_x <= 600 && mouse_x >= 100 && mouse_y <= 400 && mouse_y >= 300)
				|| (mouse_x >= 0 && mouse_x <= 500 && mouse_y >= 500 && mouse_y <= 600)) {

			tId = this.frame.getBh().getTower_id();

			if (tId == 1 && frame.getAnimator().getCoins() > 1000) {
				this.frame.getDrawingPanel().addDrawableTowerArrow(
						new ArrowTower(this.frame.getDrawingPanel(),
								"wave_1.png", 30, 100, 200,
								(((int) (mouse_x / 50)) * 50),
								(((int) (mouse_y / 50)) * 50), 1000));
				frame.getAnimator().setCoins(
						frame.getAnimator().getCoins()
								- frame.getDrawingPanel().getDrawableTowers()
										.get(0).getCost());
			}

			if (tId == 2 && frame.getAnimator().getCoins() > 1000) {
				this.frame.getDrawingPanel().addDrawableTowerFrost(
						new FrostTower(this.frame.getDrawingPanel(),
								"frostTower.png", 5, 25, 200, 2,
								(((int) (mouse_x / 50)) * 50),
								(((int) (mouse_y / 50)) * 50), 1000));
				frame.getAnimator().setCoins(
						frame.getAnimator().getCoins()
								- frame.getDrawingPanel()
										.getDrawableFrostTowers().get(0)
										.getCost());
			}

			if (tId == 3 && frame.getAnimator().getCoins() > 1000) {
				this.frame.getDrawingPanel().addDrawableTowerDeath(
						new DeathTower(this.frame.getDrawingPanel(),
								"deathTower.png", 1000, 200, 1, 20,
								(((int) (mouse_x / 50)) * 50),
								(((int) (mouse_y / 50)) * 50), 1000));
				frame.getAnimator().setCoins(
						frame.getAnimator().getCoins()
								- frame.getDrawingPanel()
										.getDrawableDeathTowers().get(0)
										.getCost());
			}

			if (tId == 4 && frame.getAnimator().getCoins() > 1000) {
				this.frame.getDrawingPanel().addDrawableTowerSplash(
						new SplashTower(this.frame.getDrawingPanel(),
								"splashTower.png", 5, 200, 50, 200,
								(((int) (mouse_x / 50)) * 50),
								(((int) (mouse_y / 50)) * 50), 1000));
				frame.getAnimator().setCoins(
						frame.getAnimator().getCoins()
								- frame.getDrawingPanel()
										.getDrawableSplashTowers().get(0)
										.getCost());
			}

			if (tId == 5 && frame.getAnimator().getCoins() > 1000) {
				this.frame.getDrawingPanel().addDrawableTowerSoulCollector(
						new SoulCollectorTower(this.frame.getDrawingPanel(),
								"soulCollector.jpg", 100, 30, 200, 5,
								(((int) (mouse_x / 50)) * 50),
								(((int) (mouse_y / 50)) * 50), 1000));
				frame.getAnimator().setCoins(
						frame.getAnimator().getCoins()
								- frame.getDrawingPanel()
										.getDrawableSoulCollectorTowers()
										.get(0).getCost());
			}

			this.frame.getDrawingPanel().repaint();
			System.out.println(this.frame.getDrawingPanel().getDrawableTowers()
					.size()
					+ " " + mouse_x + " " + mouse_y);

		} else {
			System.out.println("Out of the region" + " " + mouse_x + " "
					+ mouse_y);
			return;
		}
	}

	public void setFrame(GameFrame frame) {
		this.frame = frame;
	}

	public int getMouse_x() {
		return mouse_x;
	}

	public void setMouse_x(int mouse_x) {
		this.mouse_x = mouse_x;
	}

	public int getMouse_y() {
		return mouse_y;
	}

	public void setMouse_y(int mouse_y) {
		this.mouse_y = mouse_y;
	}

	public MouseHandler(GameFrame frame) {
		this.setFrame(frame);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// int mouse_x = arg1.getX();
		// int mouse_y = arg1.getY();
		// if (mouse_x>609&&mouse_x<697&&mouse_y>244&&mouse_y<326){
		this.setTowerDescription(towerDescription1);
		// }

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public String getTowerDescription() {
		return towerDescription;
	}

	public void setTowerDescription(String towerDescription) {
		this.towerDescription = towerDescription;
	}

}
