package ensyu2_2022;

import java.awt.Graphics;

public class Rect extends Figure{
	Rect(){}
	
	//四角の描画
	@Override public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
