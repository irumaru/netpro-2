package ensyu2_2022;

import java.awt.Graphics;

public class Polyline extends Figure{
	
	
	Polyline(){}
	
	
	
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		g.drawPolyline(getCoordXs(), getCoordYs(), count);
		/*
		if(fill)
			g.fillPolygon(getCoordXs(), getCoordYs(), count);
		else
			g.drawPolyline(getCoordXs(), getCoordYs(), count);
		*/
	}
}
