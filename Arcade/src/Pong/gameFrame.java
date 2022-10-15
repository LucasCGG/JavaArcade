package Pong;

import javax.swing.*;

public class gameFrame extends JFrame{
	public gameFrame() {
		this.add(new gamePanel());
		this.setTitle("Pong");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
