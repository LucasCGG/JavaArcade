package Pong;

import java.awt.event.*;

public class keyInput implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.upP1 = true;
			gamePanel.moveP1 = true;
			break;
		case KeyEvent.VK_S:
			gamePanel.upP1 = false;
			gamePanel.moveP1 = true;
			break;
		case KeyEvent.VK_UP:
			gamePanel.upP2 = true;
			gamePanel.moveP2 = true;
			break;
		case KeyEvent.VK_DOWN:
			gamePanel.upP2 = false;
			gamePanel.moveP2 = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.moveP1 = false;
			gamePanel.upP1 = false;
			break;
		case KeyEvent.VK_S:
			gamePanel.moveP1 = false;
			gamePanel.upP1 = false;
			break;
		case KeyEvent.VK_UP:
			gamePanel.moveP2 = false;
			gamePanel.upP2 = false;
			break;
		case KeyEvent.VK_DOWN:
			gamePanel.moveP2 = false;
			gamePanel.upP2 = false;
			break;
		}
	}
}

