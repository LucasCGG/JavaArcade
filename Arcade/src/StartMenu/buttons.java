package StartMenu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class buttons {
	Font primaryFont = new Font("Microsoft Consolas", Font.BOLD, 45);
	Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
	Stroke normal = new BasicStroke(2);

	public Rectangle pong = new Rectangle(panel.SCREEN_WIDTH / 8 + 50, panel.SCREEN_HEIGHT / 4, 200, 100);
	public Rectangle betterPong = new Rectangle(panel.SCREEN_WIDTH / 8 + 50, panel.SCREEN_HEIGHT / 3 + 75, 200, 100);
	public Rectangle snake = new Rectangle(panel.SCREEN_WIDTH / 8 + 300, panel.SCREEN_HEIGHT / 4, 200, 100);

	public void draw(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		g.setColor(Color.white);

		pongButton(g2d, primaryFont);
		betterPongButton(g2d, primaryFont);

		snakeButton(g2d, primaryFont);

	}

	public void pongButton(Graphics g, Font font) {
		// Button Border
		g.setColor(Color.white);
		((Graphics2D) g).setStroke(normal);
		g.drawRect(pong.x, pong.y, pong.width, pong.height);
		// Button Graphics
		g.setColor(Color.black);
		g.fillRect(pong.x, pong.y, pong.width, pong.height);

		g.setColor(Color.white);
		((Graphics2D) g).setStroke(dashed);
		((Graphics2D) g).drawLine(pong.x + (pong.width / 2), pong.y, pong.x + (pong.width / 2), pong.y + pong.height);

		g.fillRect(pong.x + 10, pong.y + 70, 5, 20);
		g.fillRect((pong.x + pong.width) - 15, pong.y + 25, 5, 20);

		g.fillOval((pong.x + pong.width) - 25, pong.y + 35, 5, 5);

		// Button Text
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Pong", pong.x + (pong.width / 2) - 60, pong.y + (pong.height / 2) + 15);
	}
	
	public void betterPongButton(Graphics g, Font font) {
		// Button Border
		g.setColor(Color.white);
		((Graphics2D) g).setStroke(normal);
		g.drawRect(betterPong.x, betterPong.y, betterPong.width, betterPong.height);
		// Button Graphics
		g.setColor(Color.black);
		g.fillRect(betterPong.x, betterPong.y, betterPong.width, betterPong.height);

		g.setColor(Color.white);
		((Graphics2D) g).setStroke(dashed);
		((Graphics2D) g).drawLine(betterPong.x + (betterPong.width / 2), betterPong.y, pong.x + (betterPong.width / 2), betterPong.y + betterPong.height);

		g.fillRect(betterPong.x + 25, betterPong.y + 50, 5, 30);
		g.fillRect((betterPong.x + betterPong.width) - 10, betterPong.y + 25, 5, 15);

		g.fillOval((betterPong.x + betterPong.width) - 25, betterPong.y + 30, 5,5);

		// Button Text
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Better", betterPong.x + (betterPong.width / 2) - 67, betterPong.y + (betterPong.height / 2)-10);
		g.drawString("Pong", betterPong.x + (betterPong.width / 2) - 60, betterPong.y + (betterPong.height / 2)+40);
	}

	public void snakeButton(Graphics g, Font font) {
		g.setColor(Color.white);
		((Graphics2D) g).setStroke(normal);
		g.drawRect(snake.x, snake.y, snake.width, snake.height);

		// Button Graphics
		g.setColor(Color.black);
		g.fillRect(snake.x, snake.y, snake.width, snake.height);

		// Draw Grid
		for (int i = 0; i < snake.height / 25; i++) {
			g.setColor(Color.white);
			g.drawLine(snake.x, snake.y + i * 25, snake.width + 450, snake.y + i * 25);
		}
		for (int i = 0; i < snake.width / 25; i++) {
			g.setColor(Color.white);
			g.drawLine(snake.x + i * 25, snake.y, snake.x + i * 25, snake.height + 200);
		}

		// Draw Snake
		g.setColor(new Color(45, 180, 0));
		g.fillRect(snake.x + 26, snake.y + 51, 24, 24);
		g.fillRect(snake.x + 26, snake.y + 26, 24, 24);
		g.fillRect(snake.x + 51, snake.y + 26, 24, 24);
		g.fillRect(snake.x + 76, snake.y + 26, 24, 24);
		g.fillRect(snake.x + 101, snake.y + 26, 24, 24);
		g.setColor(Color.white);
		g.fillRect(snake.x + 120, snake.y + 30, 3, 6);

		g.setColor(Color.black);
		g.fillRect(snake.x + 121, snake.y + 32, 2, 4);

		g.setColor(Color.red);
		g.fillOval(snake.x + 176, snake.y + 27, 23, 23);
		g.setColor(new Color(12, 166, 59));
		g.fillRect(snake.x + 176 + (25 / 3), snake.y + 26, 5, 4);
		g.setColor(new Color(6, 122, 42));
		g.fillRect(snake.x + 176 + (25 / 2), snake.y + 22, 3, 6);

		// Button Text
		g.setFont(font);
		g.setColor(new Color(100,100,200));
		g.drawString("Snake", snake.x + (snake.width / 2) - 57, snake.y + (snake.height / 2) + 15);

	}
}
