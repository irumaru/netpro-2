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
	
	//2点指定の図形用
	public void setWH(Integer width, Integer height) {
		setSize(width, height);
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
	//非推奨
	private void setSize(Integer width, Integer height) {
		this.width = width;
		this.height = height;
	}
	
	//図形により外側の四角形の座標計算方法が違うため、子クラス(図形ごと)で計算
	//図形移動時にわかりやすく外接する四角形を表示するために使用
	//図形に外接する四角形の基準点(左上)を取得
	public int getOutlineX() {
		return 0;
	}
	public int getOutlineY() {
		return 0;
	}
	//図形に外接する四角形の大きさ(右上)を取得
	public int getOutlineW() {
		return 0;
	}
	public int getOutlineH() {
		return 0;
	}
	
	//外接する四角を描画
	public void printOutline(Graphics g) {
		//薄めの赤
		g.setColor(new Color(255, 100, 100));
		//外接する四角を描画
		g.drawRect(getOutlineX(), getOutlineY(), getOutlineW(), getOutlineH());
	}
	
	//図形に色を適用
	public void paint(Graphics g) {
		g.setColor(color);
	}
}
