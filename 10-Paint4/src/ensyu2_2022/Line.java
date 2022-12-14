package ensyu2_2022;

import java.awt.Graphics;

public class Line extends Figure{
	Line(){}
	
	//線の描画
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		g.drawLine(x, y, x + width, y + height);
	}
	
	public int getOutlineX() {
		if(width < 0) {//横幅が-のとき
			//基準点+横幅
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
		//横幅の絶対値
		return Math.abs(width);
	}
	public int getOutlineH() {
		//高さの絶対値
		return Math.abs(height);
	}
}
