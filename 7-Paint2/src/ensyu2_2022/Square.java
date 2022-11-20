package ensyu2_2022;

import java.awt.Graphics;

public class Square extends Figure{
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		//円の描画
		if(fill)
			g.fillRect(x - width/2, y - height/2, width, height);
		else
			g.drawRect(x - width/2, y - height/2, width, height);
	}
}
