package PongBetter;

import java.awt.*;
import java.awt.event.*;


public class Player{
	public int player_height = 50;
	public static final int PLAYER_WIDTH = 15;

	int x = 50;
	int y = gamePanel.SCREEN_HEIGHT / 3;
	
	int startX1 = 50;
	int startX2 = 750;
	int startY = gamePanel.SCREEN_HEIGHT / 3;
	
	
	int x2=750;

	public int moveSpeed = 15;
	
	public float speedAmount;
	public float speed = 1.5f;
	
	public boolean move;
	public boolean moveVert;
	public boolean up;
	public boolean left;
	public boolean right;

	boolean player1;

	public void drawPlayer(Graphics g, boolean p1) {
		player1 = p1;
		if (player1) {
			g.setColor(Color.white);
			g.fillRect(x, y, PLAYER_WIDTH, player_height);
		} else {
			g.setColor(Color.white);
			g.fillRect(x2, y, PLAYER_WIDTH, player_height);
		}
	}
	

	
	public void setSpeed(float speed){
		this.speedAmount = speed;
	}
	
	public void setSize(int a, int b) {
		player_height = 50 + ((a-b)*-1)*10;
	}
	public void move() {
		if(player1) {
			up = gamePanel.upP1;
			move = gamePanel.moveP1;
			
			left = gamePanel.leftP1;
			right = gamePanel.right1;
			
			moveVert = gamePanel.moveVertP1;
		}if(!player1) {
			up = gamePanel.upP2;
			move = gamePanel.moveP2;
			
			left = gamePanel.leftP2;
			right = gamePanel.rightP2;
			
			moveVert = gamePanel.moveVertP2;
		}
		
		if (player1 && move ) {
			if (up && moveVert && y >= 20) {
				y = y -moveSpeed;
			}
			if (!up && moveVert && y + player_height <= gamePanel.SCREEN_HEIGHT - 20) {
				y = y + moveSpeed;
			}
			
			if(left && !right && x-speedAmount > 0) {
				speedAmount += +speed;
				x = (int) (x - speedAmount);
			
			}
			
			if(!left && right && ((x + PLAYER_WIDTH)+speedAmount) < gamePanel.SCREEN_WIDTH/2 ){
				speedAmount += speed;
				x = (int) (x + speedAmount);
			}
			
			
			
		}
		if (!player1 && move) {
			if (up && moveVert&& y >= 20) {
				y = y - moveSpeed;
			}
			if (!up && moveVert && y + player_height <= gamePanel.SCREEN_HEIGHT - 20) {
				y = y + moveSpeed;
			}
			if(left && !right && (x2- speedAmount) > gamePanel.SCREEN_WIDTH/2) {
				speedAmount += +speed;
				x2 = (int) (x2 - speedAmount);
			}
			
			if(!left && right && (x2 + PLAYER_WIDTH)+speedAmount < gamePanel.SCREEN_WIDTH){
				speedAmount += speed;
				x2 = (int) (x2 + speedAmount);
			}
			
		}
	}
	
	void resetPos() {
		if(player1) {
			x = startX1;
			y = startY;
		}
		if(!player1) {
			x2 = startX2;
			y = startY;
		}
	}
}
