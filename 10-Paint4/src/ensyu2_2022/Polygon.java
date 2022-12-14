package ensyu2_2022;

import java.awt.Graphics;

public class Polygon extends Figure{
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		if(fill) {
			g.fillPolygon(getCoordXArray(), getCoordYArray(), count);
		}else
			g.drawPolygon(getCoordXArray(), getCoordYArray(), count);
		
		//printOutline(g);
	}
	
	public int getOutlineX() {
		int coordXArray[] = getCoordXArray();
		
		int min = coordXArray[0];
		for(int i = 1; i < count; i ++) {
			if(coordXArray[i] < min) {
				min = coordXArray[i];
			}
		}
		
		return min;
	}
	public int getOutlineY() {
		int coordYArray[] = getCoordYArray();
		
		int min = coordYArray[0];
		for(int i = 1; i < count; i ++) {
			if(coordYArray[i] < min) {
				min = coordYArray[i];
			}
		}
		
		return min;
	}
	public int getOutlineW() {
		int coordXArray[] = getCoordXArray();
		
		int max = coordXArray[0];
		for(int i = 1; i < count; i ++) {
			if(max < coordXArray[i]) {
				max = coordXArray[i];
			}
		}
		
		return max - getOutlineX();
	}
	public int getOutlineH() {
		int coordYArray[] = getCoordYArray();
		
		int max = coordYArray[0];
		for(int i = 1; i < count; i ++) {
			if(max < coordYArray[i]) {
				max = coordYArray[i];
			}
		}
		
		return max - getOutlineY();
	}
}
