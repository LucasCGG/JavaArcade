package Snake;

import java.awt.*;

import Snake.panel.STATE;

public class player {
	final int x[] = new int[panel.GAME_UNITS];
	final int y[] = new int[panel.GAME_UNITS];
	int bodyParts = 4;
	int colorBody;

	public char dir = 'D';
	
	
	public void draw(Graphics g) {
		//Draw head and body of the snake
		for(int i = 0; i <bodyParts; i++) {
			if( i == 0) {
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], panel.UNIT_SIZE, panel.UNIT_SIZE);
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
				g.setColor(new Color(45,180,0));
				g.fillRect(x[i], y[i], panel.UNIT_SIZE, panel.UNIT_SIZE);
			}
		}
	}
	
	public void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch(dir) {
		case 'U':
			y[0] = y[0] - panel.UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + panel.UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - panel.UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + panel.UNIT_SIZE;
			break;
		}
	}
	
	
	public void checkCollision() {
		//Check if head of Snake Collides with Body
		for(int i = bodyParts; i > 0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				panel.state = STATE.GAMEOVER;
			}
		}
		//Check Collision on LEFT border
		if(x[0]<0) {
			panel.state = STATE.GAMEOVER;
		}
		//Check Collision on RIGHT border
		if(x[0]>panel.GAME_WIDTH-panel.UNIT_SIZE) {
			panel.state = STATE.GAMEOVER;
		}
		//Check Collision on TOP border
		if(y[0]<0) {
			panel.state = STATE.GAMEOVER;
		}
		//Check Collision on bottom border
		if(y[0]>panel.GAME_HEIGHT-panel.UNIT_SIZE) {
			panel.state = STATE.GAMEOVER;
		}
	}
}
