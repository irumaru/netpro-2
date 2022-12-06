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
		
		width = (int)(Math.sqrt((double)2)*Math.abs(width))*2;
		height = (int)(Math.sqrt((double)2)*Math.abs(height))*2;
		
		//width = iWidth + (width - iWidth) / 2;
		//height = iHeight + (height - iHeight) / 2; 
		
		int r = (int)Math.sqrt((double)(Math.pow(width, 2) + Math.pow(height, 2)));
		
		//円の描画
		//if(fill)
			//塗りつぶしあり
			//g.fillOval(x - r, y - r, r * 2, r * 2);
		//else
			//塗りつぶしなし
			//g.drawOval(x, y, width, height);
			g.drawOval(x - (width / 2), y - (height / 2), width, height);
	}
}
