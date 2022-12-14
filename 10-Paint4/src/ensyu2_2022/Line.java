package ensyu2_2022;

import java.awt.Graphics;

public class Line extends Figure{
	Line(){}
	
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		g.drawLine(x, y, x + width, y + height);
	}
	
	public int getOutlineX() {
		if(width < 0) {
			return x + width;
		}else {
			return x;
		}
	}
	public int getOutlineY() {
		if(height < 0) {
			return y + height;
		}else {
			return y;
		}
	}
	public int getOutlineW() {
		return Math.abs(width);
	}
	public int getOutlineH() {
		return Math.abs(height);
	}
}
