package Field;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class gamePanel extends JPanel implements ActionListener {
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE =50;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 120;
	
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 4;
	char dir = 'R';
	int colorBody;
	
	int score;
	int itemX;
	int itemY;
	
	Timer speedTimer;
	int second = 0;
	Timer timer;
	Random rand;
	boolean running = false;
	
	private menu menu;
	
	
	
	
	public enum STATE{
		MENU,GAME
	};
	public static STATE state = STATE.MENU;

	gamePanel() {
		rand = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT + 100));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		this.addMouseListener(new MouseInput());
		startGame();
	}

	public void startGame() {
		newItem();
		bodyParts = 4;
		score = 0;
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
		speedTimer();
		speedTimer.start();
		
		menu = new menu();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
	}

	public void draw(Graphics g) {
		if(state==STATE.MENU) {
			menu.draw(g);
		}
		
		if(state==STATE.GAME) {
			if (running) {
				// Draw Grid
				for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
					g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
					g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
				}
				// Draw Item
				g.setColor(Color.red);
				g.fillOval(itemX, itemY, UNIT_SIZE, UNIT_SIZE);
				g.setColor(new Color(12, 166, 59));
				g.fillRect(itemX+(UNIT_SIZE/3), itemY-1, 7,6);
				g.setColor(new Color(6, 122, 42));
				g.fillRect(itemX+(UNIT_SIZE/2), itemY-5, 5,7);
				
				// Draw Head and body of Snake
				for (int i = 0; i < bodyParts; i++) {
					if (i == 0) {
						g.setColor(Color.green);
						g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
						switch (dir) {
						case 'R':
							g.setColor(Color.black);
							g.fillRect(x[i] + 20, y[i]+5, 5, 10);
							g.setColor(Color.white);
							g.fillRect(x[i] + 22, y[i]+7, 4, 4);
							break;
						case 'L':
							g.setColor(Color.black);
							g.fillRect(x[i]+5, y[i]+5, 5, 10);
							g.setColor(Color.white);
							g.fillRect(x[i] + 3, y[i]+7, 4, 4);
							break;
						case 'D':
							g.setColor(Color.black);
							g.fillRect(x[i] + 20, y[i] + 20, 10, 5);
							g.setColor(Color.white);
							g.fillRect(x[i] + 22, y[i]+22, 4, 4);
							break;
	
						case 'U':
							g.setColor(Color.black);
							g.fillRect(x[i] +20, y[i]+5, 10, 5);
							g.setColor(Color.white);
							g.fillRect(x[i] + 22, y[i]+3, 4, 4);
							break;
						}
					}
					else {
						//Special Rainbox Body
						if (score > (UNIT_SIZE * UNIT_SIZE) - (UNIT_SIZE)) {
							colorBody = rand.nextInt(10);
							switch (colorBody) {
							case 1:
								g.setColor(new Color(45, 180, 0));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 2:
								g.setColor(new Color(14, 209, 227));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 3:
								g.setColor(new Color(121, 14, 227));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 4:
								g.setColor(new Color(126, 91, 240));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 5:
								g.setColor(new Color(221, 62, 230));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 6:
								g.setColor(new Color(230, 62, 93));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 7:
								g.setColor(new Color(247, 126, 27));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 8:
								g.setColor(new Color(207, 222, 133));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 9:
								g.setColor(new Color(3, 255, 125));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							case 10:
								g.setColor(new Color(31, 76, 105));
								g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
								break;
							}
						} else {
							g.setColor(new Color(45, 180, 0));
							g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
						}
					}
				}
				g.setColor(Color.white);
				g.setFont(new Font("Calibri", Font.ITALIC, 50));
	
				FontMetrics metrics = getFontMetrics(g.getFont());
				g.drawString("Score: " + score, (SCREEN_WIDTH - metrics.stringWidth("Score: " + score)) / 2,
						SCREEN_WIDTH + 40);
				g.drawString("Your time: " + second + "s", (SCREEN_WIDTH - metrics.stringWidth("Your Time: " + score)) / 2,
						SCREEN_WIDTH + 80);
			} else
	
			{
				gameOver(g);
			}
		}

	}

	public void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		switch (dir) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}

	public void newItem() {
		itemX = rand.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		itemY = rand.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
	}

	public void checkItem() {
		if (x[0] == itemX && y[0] == itemY) {
			bodyParts++;
			score++;
			newItem();
		}
	}

	public void checkCollision() {
		// Check if head of Snake Collides with Body
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		// Check for collision on LEFT border
		if (x[0] < 0) {
			running = false;
		}
		// Check for collision on RIGHT border
		if (x[0] > SCREEN_WIDTH) {
			running = false;
		}
		// Check for collision on TOP border
		if (y[0] < 0) {
			running = false;
		}
		// Check for collision on BOTTOM border
		if (y[0] > SCREEN_HEIGHT-30) {
			running = false;
		}
		if (!running) {
			timer.stop();
		}
	}

	public void gameOver(Graphics g) {
		// Game over Text
		g.setColor(Color.red);
		g.setFont(new Font("Calibri", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("GameOver")) / 2, SCREEN_HEIGHT / 3);
		g.setFont(new Font("Calibri", Font.ITALIC, 50));
		g.drawString("Score:" + score, (SCREEN_WIDTH - metrics.stringWidth("Score:")) / 2 + 10, SCREEN_HEIGHT / 2);
		g.drawString("Your Time: " + second + "s", (SCREEN_WIDTH - metrics.stringWidth("Your Time:")) / 2 + 25,
				SCREEN_HEIGHT / 2 + 80);
		speedTimer.stop();
	}

	public void speedTimer() {
		speedTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(state==STATE.GAME) {
		if (running) {
			move();
			checkItem();
			checkCollision();
		}
		repaint();
		}
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(state==STATE.GAME) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (dir != 'R') {
						dir = 'L';
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (dir != 'L') {
						dir = 'R';
					}
					break;
				case KeyEvent.VK_UP:
					if (dir != 'D') {
						dir = 'U';
					}
					break;
				case KeyEvent.VK_DOWN:
					if (dir != 'U') {
						dir = 'D';
					}
					break;
				}
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					if (dir != 'R') {
						dir = 'L';
					}
					break;
				case KeyEvent.VK_D:
					if (dir != 'L') {
						dir = 'R';
					}
					break;
				case KeyEvent.VK_W:
					if (dir != 'D') {
						dir = 'U';
					}
					break;
				case KeyEvent.VK_S:
					if (dir != 'U') {
						dir = 'D';
					}
					break;
				}
			}
		}
	}

}
