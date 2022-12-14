package ensyu2_2022;

import java.awt.Graphics;

public class Line extends Figure{
	Line(){}
	
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		g.drawLine(x, y, x + width, y + height);
		
		//printOutline(g);
	}
	
	public int getOutlineX() {
		return x;
	}
	public int getOutlineY() {
		return y;
	}
	public int getOutlineW() {
		return width;
	}
	public int getOutlineH() {
		return height;
	}
}
