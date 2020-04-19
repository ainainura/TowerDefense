package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.util.TimerTask;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class GameFrame extends JFrame {

	private DrawingPanel drawingPanel;
	private JPanel contentPane;
	private Animator animator = new Animator(this);
	private Timer timer = new Timer(50, animator);
	ButtonHandler bh = new ButtonHandler(this);
	private int tId;
	private int xTowerCoor;
	private int yTowerCoor;
	private JProgressBar progressBar;
	private JTextArea coins;
	private JTextArea towerDescription;
	public String description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
					frame.addContents();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	// The animator is a handler that updates the position and repaints the
	// GameFrame
	// whenever it detects an ActionEvent

	// The Timer object will fire off an ActionEvent every 50 ms, and alert
	// the
	// animator listener/handler which is being registered here

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		super("GameFrame");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 900, 625);

		// Panel

		drawingPanel = new DrawingPanel();
		drawingPanel.setBounds(5, 5, 600, 600);
		drawingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		setContentPane(drawingPanel);
		drawingPanel.setLayout(null);

		// Start Button
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnStart.setBounds(696, 502, 116, 50);
		drawingPanel.add(btnStart);
		btnStart.setActionCommand("start");

		JLabel lblChooseATower = new JLabel("Choose a tower");
		lblChooseATower.setFont(new Font("Simplified Arabic Fixed", Font.BOLD,
				14));
		lblChooseATower.setBounds(675, 203, 141, 31);
		drawingPanel.add(lblChooseATower);

		// Buttons for selecting towers
		JButton b1 = new JButton(new javax.swing.ImageIcon("wave_1.png"));
		b1.setBounds(609, 244, 88, 82);
		drawingPanel.add(b1);
		b1.setActionCommand("tower1");

		JButton b2 = new JButton(new javax.swing.ImageIcon("frostTower.png"));
		b2.setBounds(707, 244, 88, 82);
		drawingPanel.add(b2);
		b2.setActionCommand("tower2");

		JButton b3 = new JButton(new javax.swing.ImageIcon("deathTower.png"));
		b3.setBounds(803, 244, 81, 82);
		drawingPanel.add(b3);
		b3.setActionCommand("tower3");

		JButton b4 = new JButton("");
		b4.setIcon(new ImageIcon(
				"C:\\Users\\User\\Desktop\\TowerDefense\\splashTower.png"));
		b4.setBounds(650, 337, 89, 82);
		drawingPanel.add(b4);
		b4.setActionCommand("tower4");

		JButton b5 = new JButton("");
		b5.setIcon(new ImageIcon(
				"C:\\Users\\User\\Desktop\\TowerDefense\\soulCollector.jpg"));
		b5.setBounds(749, 337, 88, 82);
		drawingPanel.add(b5);
		b5.setActionCommand("tower5");

		JLabel lblLives = new JLabel("LIVES");
		lblLives.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLives.setBounds(613, 25, 70, 15);
		drawingPanel.add(lblLives);

		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 11));
		progressBar.setValue(10);
		progressBar.setStringPainted(true);
		progressBar.setMaximum(10);
		progressBar.setBounds(675, 25, 146, 14);
		drawingPanel.add(progressBar);

		JLabel lblCoins = new JLabel("COINS");
		lblCoins.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCoins.setBounds(613, 69, 53, 15);
		drawingPanel.add(lblCoins);

		coins = new JTextArea();
		coins.setBounds(687, 69, 88, 18);
		drawingPanel.add(coins);

		towerDescription = new JTextArea();
		towerDescription.setBounds(613, 110, 250, 82);
		drawingPanel.add(towerDescription);

		// This registers a new handler that listens for key presses to select
		// this image

		b1.addActionListener(bh);
		b2.addActionListener(bh);
		b3.addActionListener(bh);
		b4.addActionListener(bh);
		b5.addActionListener(bh);
		btnStart.addActionListener(bh);
		MouseHandler mh = new MouseHandler(this);
		this.addMouseListener(mh);
		this.setDescription(mh.getTowerDescription());
		this.settId(bh.getTower_id());
		this.setxTowerCoor(mh.getMouse_x());
		this.setyTowerCoor(mh.getMouse_y());

	}

	/*
	 * This method adds bubbles and Monster to the GameFrame
	 */
	public void addContents() {
		DrawingPanel dPanel = this.getDrawingPanel();

	}

	public DrawingPanel getDrawingPanel() {
		return drawingPanel;
	}

	public void setDrawingPanel(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public ButtonHandler getBh() {
		return bh;
	}

	public void setBh(ButtonHandler bh) {
		this.bh = bh;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getxTowerCoor() {
		return xTowerCoor;
	}

	public void setxTowerCoor(int xTowerCoor) {
		this.xTowerCoor = xTowerCoor;
	}

	public int getyTowerCoor() {
		return yTowerCoor;
	}

	public void setyTowerCoor(int yTowerCoor) {
		this.yTowerCoor = yTowerCoor;
	}

	public Animator getAnimator() {
		return animator;
	}

	public void setAnimator(Animator animator) {
		this.animator = animator;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public JTextArea getCoins() {
		return coins;
	}

	public void setCoins(JTextArea coins) {
		this.coins = coins;
	}

	public JTextArea getTowerDescription() {
		return towerDescription;
	}

	public void setTowerDescription(JTextArea towerDescription) {
		this.towerDescription = towerDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
