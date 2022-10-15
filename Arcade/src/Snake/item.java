package Snake;

import java.awt.*;
import java.util.*;

public class item {
	public static int itemX;
	public static int itemY;
	
	Random rand;
	public item() {
		rand = new Random();
	}
	
	public void newItem() {
		int x = rand.nextInt((int)(panel.GAME_WIDTH/panel.UNIT_SIZE)) * panel.UNIT_SIZE;
		int y = rand.nextInt((int)(panel.GAME_WIDTH/panel.UNIT_SIZE)) * panel.UNIT_SIZE;
		
		for(int i = 0; i<panel.player.bodyParts; i++) {
			if(x != panel.player.x[i] && y != panel.player.y[i]) {
				
					itemX = x;
					itemY = y;
				
			}
			else {
				System.out.println("Invalid Spawnpoint");
				
					newItem();
					break;
			
			}
			}
		}
		
	
	
	
	public static void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(itemX, itemY, panel.UNIT_SIZE, panel.UNIT_SIZE);
		g.setColor(new Color(12, 166, 59));
		g.fillRect(itemX+(panel.UNIT_SIZE/3), itemY-1, 7,6);
		g.setColor(new Color(6, 122, 42));
		g.fillRect(itemX+(panel.UNIT_SIZE/2), itemY-5, 5,7);
	}
}
