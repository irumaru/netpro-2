//カラー

package ensyu2_2022;

import java.awt.Color;
import java.awt.Graphics;

//図形の色やサイズや塗りつぶしに関することを記述
public class Figure extends Coord{
	Color color;//色
	Boolean fill;//塗りつぶしの有無
	Integer width;//幅
	Integer height;//高さ
	
	Figure(){
		//黒で初期化(実際はColorPickerUtilityの初期化が使用される)
		setColor(new Color(0 ,0 ,0));
		
		//サイズの初期化
		width = height = 0;
		
		//塗りつぶしの初期化(塗りつぶしなし)
		fill = false;
	}
	
	//以下は各プロパティのゲッターとセッター
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Boolean getFill() {
		return fill;
	}
	
	public void setFill(Boolean fill) {
		this.fill = fill;
	}
	
	public Integer[] getSize() {
		return new Integer[] {width, height};
	}
	
	public void setSize(Integer width, Integer height) {
		this.width = width;
		this.height = height;
	}
	
	//色を適用
	public void paint(Graphics g) {
		g.setColor(color);
	}
}
