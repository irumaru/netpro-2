//円オブジェクト

package ensyu2_2022;

import java.awt.Graphics;

public class Circle extends Figure {
	Circle(){}
	
	@Override public void paint(Graphics g){ // 描画のための処理
		//スーパークラスのメソッドを呼び出し
		super.paint(g);
		
		//円の描画
		if(fill)
			g.fillOval(x - width/2, y - height/2, width, height);
		else
			g.drawOval(x - width/2, y - height/2, width, height);
	}
}