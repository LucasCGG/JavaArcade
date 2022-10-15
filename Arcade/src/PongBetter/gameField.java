package PongBetter;

import java.awt.*;

public class gameField {
	public void drawField(Graphics g, int x1, int y1, int x2, int y2) {
		Graphics2D g2d = (Graphics2D) g.create();
		Stroke dashed = new BasicStroke(3,BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,0,new float[]{9}, 0);
		
		g2d.setColor(Color.white);
		g2d.setStroke(dashed);
		g2d.drawLine(x1, y1, x2, y2);
	}
}
