package Field;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import UI.gamePanel;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		// TODO Auto-generated method stub
		/**
		 * 	public Rectangle playButton = new Rectangle(gamePanel.SCREEN_WIDTH/4+50,200,200,100);
	public Rectangle quitButton = new Rectangle(gamePanel.SCREEN_WIDTH/4+50,350,200,100);

		 */
		
		//play Button
		if(mx >= gamePanel.SCREEN_WIDTH/4+50 && mx<=gamePanel.SCREEN_WIDTH/3+250) {
			if(my>=200 && my<=300) {
				gamePanel.state = gamePanel.STATE.GAME;
			}
		}
		//quit Button
		if(mx >= gamePanel.SCREEN_WIDTH/4+50&& mx<=gamePanel.SCREEN_WIDTH/3+250) {
			if(my>=350&&my<=450) {
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
