//カラー

package ensyu2_2022;

import java.awt.Color;
import java.awt.Graphics;

public class Figure extends Coord{
	protected Color color;
	protected Boolean fill;
	protected Integer width;
	protected Integer height;
	
	Figure(){
		//黒で初期化
		setColor(new Color(0 ,0 ,0));
		
		//サイズの初期化
		width = height = 0;
		
		//塗りつぶしの初期化
		fill = false;
	}
	
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
	
	public Integer[] getWidth() {
		return new Integer[] {width, height};
	}
	
	public void setSize(Integer width, Integer height) {
		this.width = width;
		this.height = height;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
	}
}
