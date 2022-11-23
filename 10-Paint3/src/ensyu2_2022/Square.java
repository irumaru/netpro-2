package ensyu2_2022;

import java.awt.Graphics;

//図形の形が四角形であることと、それに付随する名前以外は、Circleクラスと同様
public class Square extends Figure{
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		if(fill)
			g.fillRect(x - width/2, y - height/2, width, height);
		else
			g.drawRect(x - width/2, y - height/2, width, height);
	}
}
