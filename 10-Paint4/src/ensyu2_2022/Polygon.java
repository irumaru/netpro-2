package ensyu2_2022;

import java.awt.Graphics;

public class Polygon extends Figure{
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		if(fill) {
			g.fillPolygon(getCoordXArray(), getCoordYArray(), count);
		}else
			g.drawPolygon(getCoordXArray(), getCoordYArray(), count);
	}
	
	
	public int getOutlineX() {
		return CustomMath.min(count, getCoordXArray());
	}
	public int getOutlineY() {
		return CustomMath.min(count, getCoordYArray());
	}
	public int getOutlineW() {
		return CustomMath.max(count, getCoordXArray()) - getOutlineX();
	}
	public int getOutlineH() {
		return CustomMath.max(count, getCoordYArray()) - getOutlineY();
	}
}
