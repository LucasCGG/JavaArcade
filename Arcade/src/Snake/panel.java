package Snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class panel extends JPanel implements ActionListener {
	static final int GAME_WIDTH = 750;
	static final int GAME_HEIGHT = 750;
	static final int UNIT_SIZE = 75;
	static final int GAME_UNITS = (GAME_WIDTH * GAME_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 300;
	

	
	
	public item item;
	int score = 0;

	Timer speedTimer;
	int second = 0;
	Timer timer;
	Random rand;
	boolean running = false;

	public static player player;

	public enum STATE {
		MENU, PAUSE, GAME, GAMEOVER
	}

	public static STATE state = STATE.MENU;

	private Color menuColor = new Color(75, 85, 75, 100);
	private Color gameOverColor = new Color(36, 24, 24, 200);
	
	Font title=(new Font("Calibri", Font.BOLD, 75));

	Font subTitle=(new Font("Calibri", Font.BOLD, 35));

	panel() {
		rand = new Random();
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		timer = new Timer(DELAY, this);
		startGame();
	}

	private void startGame() {
		running = true;
		
		timer.start();

		player = new player();
		item = new item();
		item.newItem();
		score = 0;

		state = STATE.GAME;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		if (running) {
			// Draw Grid
			for (int i = 0; i < GAME_HEIGHT / UNIT_SIZE; i++) {
				g.setColor(Color.white);
				g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, GAME_HEIGHT);
				g.drawLine(0, i * UNIT_SIZE, GAME_WIDTH, i * UNIT_SIZE);
			}

			Snake.item.draw(g);
			player.draw(g);
			
			
			g.setColor(Color.white);
			g.setFont(subTitle);
			g.drawString("Score: " + score, GAME_WIDTH/3 + 65, 30);
		}

		if (state == STATE.PAUSE) {
			pauseMenu(g);
		}

		if (state == STATE.GAMEOVER) {
			gameOver(g);
		}
		
		
		
	}

	public void checkItem() {
		if (player.x[0] == item.itemX && player.y[0] == item.itemY) {
			player.bodyParts++;
			score++;
			item.newItem();
			System.out.println("COLLECTED");
		}
	}

	void pauseMenu(Graphics g) {
		g.setColor(menuColor);
		g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

		g.setColor(Color.white);
		g.setFont(title);
		g.drawString("Game Paused", GAME_WIDTH / 3 - 90, GAME_HEIGHT / 3);

		g.setFont(subTitle);
		g.drawString("Press 'ENTER' to continue", GAME_WIDTH / 3 - 65, GAME_HEIGHT / 3 + 100);
	}

	void gameOver(Graphics g) {
		g.setColor(gameOverColor);
		g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

		g.setColor(Color.white);
		g.setFont(title);
		g.drawString("Game Over", GAME_WIDTH / 3 - 50, GAME_HEIGHT / 3);
		
		g.setColor(Color.white);
		g.setFont(subTitle);
		g.drawString("Your score was: " + score, GAME_WIDTH/3, GAME_HEIGHT/3 + 50);

		g.setFont(subTitle);
		g.drawString("Press 'ENTER' to restart", GAME_WIDTH/3-42, GAME_HEIGHT/3 + 200);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (running) {
			if (state == STATE.GAME) {
				player.move();
				player.checkCollision();
				checkItem();
			}
			repaint();
		}
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (state == STATE.GAMEOVER) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					startGame();
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
					break;
				}
			}

			if (state == STATE.PAUSE) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					state = STATE.GAME;
					break;
				}
			}
			// Keyinput for ARROW BUTTONS
			if (state == STATE.GAME) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (player.dir != 'R') {
						player.dir = 'L';
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (player.dir != 'L') {
						player.dir = 'R';
					}
					break;
				case KeyEvent.VK_UP:
					if (player.dir != 'D') {
						player.dir = 'U';
					}
					break;
				case KeyEvent.VK_DOWN:
					if (player.dir != 'U') {
						player.dir = 'D';
					}
					break;
				}
			}

				// Keyinput for WASD
			if(state == STATE.GAME) {	
			switch (e.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					state = STATE.PAUSE;
					System.out.println("TEST");
					break;
				case KeyEvent.VK_A:
					if (player.dir != 'R') {
						player.dir = 'L';
					}
					break;
				case KeyEvent.VK_D:
					if (player.dir != 'L') {
						player.dir = 'R';
					}
					break;
				case KeyEvent.VK_W:
					if (player.dir != 'D') {
						player.dir = 'U';
					}
					break;
				case KeyEvent.VK_S:
					if (player.dir != 'U') {
						player.dir = 'D';
					}
					break;
				}
			}
		}
	}
}
