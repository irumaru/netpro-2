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
		
		int r = getRadius();
		
		//円の描画
		if(fill)
			//塗りつぶしあり
			g.fillOval(x - r, y - r, r * 2, r * 2);
		else
			//塗りつぶしなし
			g.drawOval(x - r, y - r, r * 2, r * 2);
	}
	
	//半径を取得
	private int getRadius() {
		return (int)Math.sqrt((double)(width * width + height * height));
	}
	
	public int getOutlineX() {
		return x - getRadius();
	}
	public int getOutlineY() {
		return y - getRadius();
	}
	public int getOutlineW() {
		return getRadius() * 2;
	}
	public int getOutlineH() {
		return getRadius() * 2;
	}
}