package ensyu2_2022;

import java.awt.Graphics;

public class Oval extends Figure{
	//コンストラクタ未使用
	Oval(){}
	
	//円の描画
	@Override public void paint(Graphics g){
		//スーパークラス(Figure)のインスタンスのメソッドを呼び出し
		super.paint(g);
		
		//楕円に外接する四角形
		int width = getCenterToOutline(this.width);
		int height = getCenterToOutline(this.height);

		//円の描画
		if(fill)
			//塗りつぶしあり
			g.fillOval(x - (width / 2), y - (height / 2), width, height);
		else
			//塗りつぶしなし
			g.drawOval(x - (width / 2), y - (height / 2), width, height);
	}
	
	private int getCenterToOutline(int wh) {
		return (int)(Math.sqrt((double)2)*Math.abs(wh))*2;
	}
	public int getOutlineX() {
		return x - (getCenterToOutline(width) / 2);
	}
	public int getOutlineY() {
		return y - (getCenterToOutline(height) / 2);
	}
	public int getOutlineW() {
		return getCenterToOutline(width);
	}
	public int getOutlineH() {
		return getCenterToOutline(height);
	}
}
