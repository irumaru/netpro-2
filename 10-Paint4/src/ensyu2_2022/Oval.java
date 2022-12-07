package ensyu2_2022;

import java.awt.Graphics;

public class Oval extends Figure{
	//コンストラクタ未使用
	Oval(){}
	
	//円の描画
	@Override public void paint(Graphics g){
		//スーパークラス(Figure)のインスタンスのメソッドを呼び出し
		super.paint(g);
		
		//GraphicsのRect系に合わせるために値を変更するため、ローカル変数へ複製
		int x = this.x;
		int y = this.y;
		int width = this.width;
		int height = this.height;
		
		//楕円に内接する四角形
		width = (int)(Math.sqrt((double)2)*Math.abs(width))*2;
		height = (int)(Math.sqrt((double)2)*Math.abs(height))*2;

		//円の描画
		if(fill)
			//塗りつぶしあり
			g.fillOval(x - (width / 2), y - (height / 2), width, height);
		else
			//塗りつぶしなし
			g.drawOval(x - (width / 2), y - (height / 2), width, height);
	}
}
