package Pong;

import java.awt.*;
import java.util.*;



public class ball {
	int radius = 15;
	public int speedMultiplier = 3;
	public float hits=0;
	public int xDir;
	public int yDir;
	
	int startPosX = gamePanel.SCREEN_WIDTH/2-radius/2;
	int startPosY = gamePanel.SCREEN_HEIGHT/2;
	
	public int x = gamePanel.SCREEN_WIDTH/2-radius/2;
	public int y= gamePanel.SCREEN_HEIGHT/2;
	
	Random rand = new Random(1);
	
	public ball() {
		int xrDir = rand.nextInt(1);
		if(xrDir==0) {
			xrDir--;
		}
		setXDirection(xrDir);
		
		int yrDir = rand.nextInt(1);	
		if(yrDir==0){
			yrDir--;
		}
		setYDirection(yrDir);
	}
	public void drawBall(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(x, y, radius, radius);
	}
	
	public void setXDirection(int x) {
		xDir= (int)(x * (speedMultiplier + hits));
	}
	
	public void setYDirection(int y) {
		yDir = (int) (y * (speedMultiplier + hits));
	}
	
	public void move() {
		x += xDir;
		y += yDir;
		
		if(x<=0) {
			x = startPosX;
			y = startPosY;
			setXDirection(-1);
			gamePanel.score2++;
			hits = 0;
			
		}
		if(x >= gamePanel.SCREEN_WIDTH) {
			x = startPosX;
			y = startPosY;
			setXDirection(+1);
			gamePanel.score1++;
			hits = 0;
		}
		
		if(y <= 0) {
			setYDirection(+1);
		}
		if(y >= gamePanel.SCREEN_HEIGHT-(2*radius)) {
			setYDirection(-1);
		}
	}
	
	public void collision(int xP1, int yP1, int xP2, int yP2, int pHeight, int pWidth) {
		if(x < xP1+pWidth + radius && x > xP1&& y > yP1 && y < yP1 + pHeight) {
			setXDirection(+1);
			hits += 0.25;
		}
		if(x > xP2-(radius*2) && x < xP2+pWidth && y > yP2 && y < yP2 + pHeight) {
			setXDirection(-1);
			hits += 0.25;
		}
	}
}
