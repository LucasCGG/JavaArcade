package PongBetter;

import commonSettings.screenSettings;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import UI.Overrideif;
import UI.mouseInput;
import UI.startMenu;
import UI.gamePanel.STATE;
import UI.gamePanel.myKeyAdapter;

public class gamePanel extends JPanel implements ActionListener {
	
	// Field
	gameField gameField = new gameField();
	
	// Player
	public static Player p1 = new Player();
	public static Player p2 = new Player();
	public static boolean upP1;
	public static boolean moveP1;
	public static boolean upP2;
	public static boolean moveP2;
	public static boolean rightP2;
	public static boolean leftP2;
	public static boolean right1;
	public static boolean leftP1;
	
	public static boolean moveVertP1;
	public static boolean moveVertP2;
	
	// Ball
	ball ball = new ball();
	// Score
	public static int score1;
	public static int score2;
	public boolean score;

	// Game Settings
	public static enum STATE {MENU,GAME};

	public static STATE state = STATE.MENU;

	static final int SCREEN_WIDTH = 1200;
	static final int SCREEN_HEIGHT = 800;
	boolean running = true;
	static final int DELAY = 10;
	Timer timer;
	
	Timer countDownTimer;
	int seconds;
	

	gamePanel() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new keyInput());
		this.addMouseListener(new Pong.mouseInput());

		countDown();
		countDownTimer.start();
		seconds = 5;
	}

	public void start() {
			countDownTimer.stop();
			timer = new Timer(DELAY, this);
			timer.start();
			running = true;
			
			score1=0;
			score2=0;
			
			
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		if(seconds>0) {
			drawCountDown(g);
		}
		if (running) {
			gameField.drawField(g, SCREEN_WIDTH / 2, 0, SCREEN_WIDTH / 2, SCREEN_HEIGHT);
			drawScore(g);
			
			
			p1.drawPlayer(g, true);

			p2.drawPlayer(g, false);
			 
			if(score1 - score2<0) {
				p1.setSize(score1,score2);
			}
			else if(score1-score2>0) {
				p2.setSize(score2,score1);
			}
			System.out.println(p1.player_height+ " "+p2.player_height);
			
			ball.drawBall(g);
			if(seconds<=0) {
				ball.move(g);
				ball.collision(p1.x, p1.y, p2.x2, p2.y, p1.player_height,p2.player_height, p1.PLAYER_WIDTH);
		
			}
		}
	}
	

	
	public void drawScore(Graphics g) {
		g.setFont(new Font("Calibri", Font.BOLD, 25));
		if (score1 - score2 < 0) {
			g.setColor(Color.red);
			g.drawString("Score: " + score1, SCREEN_WIDTH / 4, 50);
			g.setColor(Color.green);
			g.drawString("Score: " + score2, (SCREEN_WIDTH - SCREEN_WIDTH / 3), 50);
		}
		if (score1 - score2 > 0) {
			g.setColor(Color.green);
			g.drawString("Score: " + score1, SCREEN_WIDTH / 4, 50);
			g.setColor(Color.red);
			g.drawString("Score: " + score2, (SCREEN_WIDTH - SCREEN_WIDTH / 3), 50);
		} else if (score1 - score2 == 0) {
			g.setColor(Color.white);
			g.drawString("Score: " + score1, SCREEN_WIDTH / 4, 50);
			g.drawString("Score: " + score2, (SCREEN_WIDTH - SCREEN_WIDTH / 3), 50);
		}
		g.setColor(Color.white);
	}

	
	
	public void countDown() {
		countDownTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				if(seconds<=0) {
					start();
				}
				repaint();
				System.out.println(seconds);
			}
		});
	}
	public void drawCountDown(Graphics g) {
		this.setBackground(Color.black);
		this.setOpaque(true);
		g.setColor(Color.red);
		g.setFont(new Font("arial", Font.BOLD, 100));
		g.drawString(""+seconds, SCREEN_WIDTH/2-30, SCREEN_HEIGHT/2-20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		
		// TODO Auto-generated method stub
		if (running) {
			p1.move();
			p2.move();
		}
		repaint();
		
		//System.out.println(ball.xDir+" "+ball.yDir);
	}

	public static void pointP2(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect(0, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT);
		
		
	}
	
	public static void pointP1(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect(SCREEN_WIDTH/2, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT);
	}
}
