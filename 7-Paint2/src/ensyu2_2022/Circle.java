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
		
		//円の描画
		if(fill)
			//塗りつぶしあり
			g.fillOval(x - width/2, y - height/2, width, height);
		else
			//塗りつぶしなし
			g.drawOval(x - width/2, y - height/2, width, height);
	}
}