package ensyu2_2022;

import java.awt.Graphics;
import java.util.ArrayList;

public class Polyline extends Figure{
	ArrayList<Integer> coordXList;
	ArrayList<Integer> coordYList;
	Integer forcusX, forcusY, count;
	
	Polyline(){
		coordXList = new ArrayList<Integer>();
		coordYList = new ArrayList<Integer>();
		count = 0;
	}
	
	@Override public void moveto(int x, int y) {
		super.moveto(x, y);
		
		setXY(x, y);
	}
	
	public void setXY(Integer x, Integer y) {
		coordXList.add(x);
		coordYList.add(y);
	}
	
	public void forcusXY(int x, int y) {
		forcusX = x;
		forcusY = y;
	}
	
	private int[] getIntArray(ArrayList<Integer> coords, Integer forcus) {
		int[] coordsInt = new int[coords.size() + 1];
		
		for(int i = 0; i < coords.size(); i ++) {
			coordsInt[i] = coords.get(i);
		}
		
		count = coords.size();
		
		if(forcus != null) {
			coordsInt[coords.size()] = forcus;
			count ++;
		}
		
		return coordsInt;
	}
	
	private int[] getCoordXs() {
		return getIntArray(coordXList, forcusX);
	}
	
	private int[] getCoordYs() {
		return getIntArray(coordYList, forcusY);
	}
	
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		if(fill)
			g.fillPolygon(getCoordXs(), getCoordYs(), count);
		else
			g.drawPolyline(getCoordXs(), getCoordYs(), count);
	}
}
