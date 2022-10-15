package Pong;

import java.awt.*;
import java.awt.event.*;

public class Player{
	public static final int PLAYER_HEIGHT = 50;
	public static final int PLAYER_WIDTH = 15;

	int x = 50;
	int y = gamePanel.SCREEN_HEIGHT / 3;
	
	int x2=750;

	public int moveSpeed = 15;
	public boolean move;
	public boolean up;

	boolean player1;

	public void drawPlayer(Graphics g, boolean p1) {
		player1 = p1;
		if (player1) {
			g.setColor(Color.white);
			g.fillRect(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
		} else {
			g.setColor(Color.white);
			g.fillRect(x2, y, PLAYER_WIDTH, PLAYER_HEIGHT);
		}
	}

	public void move() {
		if(player1) {
			up = gamePanel.upP1;
			move = gamePanel.moveP1;
		}if(!player1) {
			up = gamePanel.upP2;
			move = gamePanel.moveP2;
		}
		
		if (player1 && move) {
			if (up && y >= 20) {
				y = y -moveSpeed;
			}
			if (!up && y + PLAYER_HEIGHT <= gamePanel.SCREEN_HEIGHT - 20) {
				y = y + moveSpeed;
			}
		}
		if (!player1 && move) {
			if (up && y >= 20) {
				y = y - moveSpeed;
			}
			if (!up && y + PLAYER_HEIGHT <= gamePanel.SCREEN_HEIGHT - 20) {
				y = y + moveSpeed;
			}
		}
	}
}
