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
		
		//widthが-の値の時に反対側に拡張
		if(width < 0) {
			//x = x + width;
			width = - width;
		}
		//heightが-の値の時に反対側に拡張
		if(height < 0) {
			//y = y + height;
			height = - height;
		}
		
		int oWidth = (int)(width * Math.pow(2, 0.5));
		int oHeight = (int)(height * Math.pow(2, 0.5));
		
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
			g.drawOval(x - (width / 2), y - (height / 2), oWidth, oHeight);
	}
}
