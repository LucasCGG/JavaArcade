package StartMenu;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import UI.MenuFrame;

public class mouseInput implements MouseListener{
		
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//(PONG) new Rectangle(panel.SCREEN_WIDTH/8+50, panel.SCREEN_HEIGHT/4,200,100);
		//(BETTER PONG)new Rectangle(panel.SCREEN_WIDTH / 8 + 50, panel.SCREEN_HEIGHT / 3 + 75, 200, 100);
		//(Snake) new Rectangle(panel.SCREEN_WIDTH / 8 + 300, panel.SCREEN_HEIGHT / 4, 200, 100);
		
		int mx = e.getX();
		int my = e.getY();
		
		//CHECK PONG BUTTON
		if(mx >= panel.SCREEN_WIDTH/8+50 && mx <= panel.SCREEN_WIDTH/8+250) {
			if(my >= panel.SCREEN_HEIGHT/4 && my <= panel.SCREEN_HEIGHT/4 + 100) {
			System.out.println("Starting Pong ...");
			;
			new Pong.gameFrame();
			}
		}
		//CHECK BETTER PONG BUTTON
		if(mx >= panel.SCREEN_WIDTH/8+50 && mx <= panel.SCREEN_WIDTH/8+250) {
			if(my >= panel.SCREEN_HEIGHT/3+75 && my <= panel.SCREEN_HEIGHT/3 + 175) {
			System.out.println("Starting Better Pong ...");
			;
			new PongBetter.gameFrame();
			}
		}
		
		//CHECK SNAKE BUTTON
		if(mx >= panel.SCREEN_WIDTH / 8 + 300 && mx<panel.SCREEN_WIDTH / 8 + 500) {
			if(my >= panel.SCREEN_HEIGHT/4 && my <= panel.SCREEN_HEIGHT/4 + 100) {
				System.out.println("Starting Snake ...");
				new Snake.frame();
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
