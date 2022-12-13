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
}
