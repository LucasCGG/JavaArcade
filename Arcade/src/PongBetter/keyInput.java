package PongBetter;

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
			gamePanel.moveVertP1 = true;
			break;
		case KeyEvent.VK_S:
			gamePanel.upP1 = false;
			gamePanel.moveP1 = true;
			gamePanel.moveVertP1 = true;
			break;
		case KeyEvent.VK_UP:
			gamePanel.upP2 = true;
			gamePanel.moveP2 = true;
			gamePanel.moveVertP2 = true;
			break;
		case KeyEvent.VK_DOWN:
			gamePanel.upP2 = false;
			gamePanel.moveP2 = true;
			gamePanel.moveVertP2 = true;
			break;
		case KeyEvent.VK_I:
			gamePanel.upP2 = true;
			gamePanel.moveP2 = true;
			gamePanel.moveVertP2 = true;
			break;
		case KeyEvent.VK_K:
			gamePanel.upP2 = false;
			gamePanel.moveP2 = true;
			gamePanel.moveVertP2 = true;
			break;
		
		case KeyEvent.VK_A:
			gamePanel.leftP1 = true;
			gamePanel.right1 = false;
			gamePanel.moveP1 = true;
			break;
		case KeyEvent.VK_D:
			gamePanel.leftP1 = false;
			gamePanel.right1 = true;
			gamePanel.moveP1 = true;
			break;
		case KeyEvent.VK_LEFT:
			gamePanel.leftP2 = true;
			gamePanel.rightP2 = false;
			gamePanel.moveP2 = true;
			break;
		case KeyEvent.VK_RIGHT:
			gamePanel.leftP2 = false;
			gamePanel.rightP2 = true;
			gamePanel.moveP2 = true;
			break;
		case KeyEvent.VK_J:
			gamePanel.leftP2 = true;
			gamePanel.rightP2 = false;
			gamePanel.moveP2 = true;
			break;
		case KeyEvent.VK_L:
			gamePanel.leftP2 = false;
			gamePanel.rightP2 = true;
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
			gamePanel.moveVertP1 = false;
			break;
		case KeyEvent.VK_S:
			gamePanel.moveP1 = false;
			gamePanel.upP1 = false;
			gamePanel.moveVertP1 = false;
			break;
			
		case KeyEvent.VK_UP:
			gamePanel.moveP2 = false;
			gamePanel.upP2 = false;
			gamePanel.moveVertP2 = false;
			break;
		case KeyEvent.VK_DOWN:
			gamePanel.moveP2 = false;
			gamePanel.upP2 = false;
			gamePanel.moveVertP2 = false;
			break;
		case KeyEvent.VK_I:
			gamePanel.moveP2 = false;
			gamePanel.upP2 = false;
			gamePanel.moveVertP2 = false;
			break;
		case KeyEvent.VK_K:
			gamePanel.moveP2 = false;
			gamePanel.upP2 = false;
			gamePanel.moveVertP2 = false;
			break;
		case KeyEvent.VK_A:
			gamePanel.leftP1 = false;
			gamePanel.moveP1 = true;
			gamePanel.p1.setSpeed(0);
			break;
		case KeyEvent.VK_D:
			gamePanel.right1 = false;
			gamePanel.moveP1 = true;
			gamePanel.p1.setSpeed(0);
			break;
		case KeyEvent.VK_LEFT:
			gamePanel.leftP2 = false;
			gamePanel.moveP2 = true;
			gamePanel.p2.setSpeed(0);
			break;
		case KeyEvent.VK_RIGHT:
			gamePanel.rightP2 = false;
			gamePanel.moveP2 = true;
			gamePanel.p2.setSpeed(0);
			break;
		case KeyEvent.VK_J:
			gamePanel.leftP2 = false;
			gamePanel.moveP2 = true;
			gamePanel.p2.setSpeed(0);
			break;
		case KeyEvent.VK_L:
			gamePanel.rightP2 = false;
			gamePanel.moveP2 = true;
			gamePanel.p2.setSpeed(0);
			break;
		}
	}
}

