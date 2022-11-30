package ensyu2_2022;

import java.awt.Graphics;

public class Line extends Figure{
	Line(){}
	
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		g.drawLine(x, y, x + width, y + height);
	}
}
