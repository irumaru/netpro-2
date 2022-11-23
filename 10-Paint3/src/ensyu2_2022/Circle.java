//円オブジェクト

package ensyu2_2022;

import java.awt.Graphics;

public class Circle extends Figure {
	//コンストラクタ未使用
	Circle(){}
	
	//円の描画
	@Override public void paint(Graphics g){
		//スーパークラス(Figure)のインスタンスのメソッドを呼び出し
		super.paint(g);
		
		int r = (int)Math.sqrt((double)(width * width + height * height));
		
		//円の描画
		if(fill)
			//塗りつぶしあり
			g.fillOval(x - r, y - r, r * 2, r * 2);
		else
			//塗りつぶしなし
			g.drawOval(x - r, y - r, r * 2, r * 2);
	}
}