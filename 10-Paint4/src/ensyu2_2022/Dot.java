package ensyu2_2022;

import java.awt.Graphics;

public class Dot extends Figure{
	//Integer size;
	
	Dot(){
		//size = 10;
		width = height = 10;
	}
	
	//丸の描画
	@Override public void paint(Graphics g){
		//スーパークラス(Figure)のインスタンスのメソッドを呼び出し
		super.paint(g);
		
		//丸の描画
		if(fill)
			//塗りつぶしあり
			g.fillOval(x - width/2, y - height/2, width, height);
		else
			//塗りつぶしなし
			g.drawOval(x - width/2, y - height/2, width, height);
	}
	
	public int getOutlineX() {
		return x - (width / 2);
	}
	public int getOutlineY() {
		return y - (height / 2);
	}
	public int getOutlineW() {
		return width;
	}
	public int getOutlineH() {
		return height;
	}
}
