package Field;

import java.awt.*;
import javax.swing.*;

public class menu extends JPanel{
	
	public Rectangle playButton = new Rectangle(gamePanel.SCREEN_WIDTH/4+50,200,200,100);
	public Rectangle quitButton = new Rectangle(gamePanel.SCREEN_WIDTH/4+50,350,200,100);

	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		g.setColor(Color.white);
		g.setFont(new Font("Calibri", Font.BOLD, 150));
		
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Snake", (gamePanel.SCREEN_WIDTH - metrics.stringWidth("Snake")) / 2, gamePanel.SCREEN_HEIGHT / 5);
		
		g.setFont(new Font("Arial", Font.HANGING_BASELINE,75));
		g.drawString("Play", playButton.x+playButton.width/7, playButton.y+(playButton.height/4+playButton.height/2));
		g2d.draw(playButton);
		g.drawString("Quit", quitButton.x+quitButton.width/7, quitButton.y+(quitButton.height/4+quitButton.height/2));
		g2d.draw(quitButton);
	}
}
