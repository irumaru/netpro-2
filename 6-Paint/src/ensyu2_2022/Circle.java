package ensyu2_2022;

import java.awt.Graphics;

public class Circle extends Coord {
	int color, size;
	Circle(){
		color = 0;
		size = 10;
	}
	@Override public void paint(Graphics g){ // 描画のための処理
		g.drawOval(x - size/2, y - size/2, size, size);
	}
	@Override public void move(int dx, int dy) {
		x += dx;
		y += dy;
		
		//System.out.println("move2");
	}
	/*
	public void setSize(int s) {
		size = s;
	}
	*/
}