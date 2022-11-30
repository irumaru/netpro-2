package ensyu2_2022;

import java.awt.Graphics;

public class Rect extends Figure{
	Rect(){}
	
	//四角の描画
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		//GraphicsのRect系に合わせるために値を変更するため、ローカル変数へ複製
		int x = this.x;
		int y = this.y;
		int width = this.width;
		int height = this.height;
		
		//widthが-の値の時に反対側に拡張
		if(width < 0) {
			x = x + width;
			width = - width;
		}
		//heightが-の値の時に反対側に拡張
		if(height < 0) {
			y = y + height;
			height = - height;
		}
			
		if(fill)
			g.fillRect(x, y, width, height);
		else
			g.drawRect(x, y, width, height);
	}
}
