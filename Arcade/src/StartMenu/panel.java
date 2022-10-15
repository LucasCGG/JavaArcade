package StartMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class panel extends JPanel implements ActionListener{
	static final int SCREEN_WIDTH = 1200;
	static final int SCREEN_HEIGHT =  800;
	static final int DELAY = 120;
	
	buttons button;
	
	Timer gameTimer;
	int seconds = 0;
	boolean running = false;
	
	
	panel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addMouseListener(new mouseInput());
		
		start();
	}
	
	public void start(){
		button = new buttons();
		
		running = true;
		gameTimer = new Timer(DELAY,this);
		gameTimer.start();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}
	
	void draw(Graphics g) {
		button.draw(g);
		
		g.setColor(Color.white);
		g.setFont(new Font("Microsoft Consolas", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Arcade Games", (SCREEN_WIDTH-metrics.stringWidth("Arcade Game"))/2, SCREEN_HEIGHT/6);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
