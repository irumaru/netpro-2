package ensyu2_2022;

import java.awt.Graphics;

public class Rect extends Figure{
	Rect(){}
	
	//四角の描画
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		//GraphicsのRect系に合わせるために値を変更するため、ローカル変数へ複製
		int x = getOutlineX();
		int y = getOutlineY();
		int width = getOutlineW();
		int height = getOutlineH();
			
		if(fill)
			g.fillRect(x, y, width, height);
		else
			g.drawRect(x, y, width, height);
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
