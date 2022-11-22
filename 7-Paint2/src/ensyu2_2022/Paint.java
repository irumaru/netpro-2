//メインのペイントプログラム

package ensyu2_2022;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

//フレームオブジェクトを継承
public class Paint extends Frame implements MouseListener,MouseMotionListener {
	int x, y;
	
	ArrayList<Figure> objList;
	Figure obj;
	
	TextFieldUtility size;
	TextFieldUtility width;
	TextFieldUtility height;
	ChoiceFieldUtility fill;
	ChoiceFieldUtility shape;
	//ChoiceFieldUtility sampleColor;
	ColorPickerUtility color;
	
	int objPrintCount = 0;
	
	public static void main(String[] args){
		Paint f = new Paint();
		f.setSize(800,600);
		//f.setLayout(null);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.setTitle("Paint␣Sample");
		f.addWindowListener(new WindowAdapter(){
			@Override public void windowClosing(WindowEvent e){
				System.exit(0);
			}});
		f.setVisible(true);
	}
	
	Paint(){
		objList = new ArrayList<Figure>();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		//ユーティリティの表示
		size = new TextFieldUtility(this, "オブジェクト数", "0");
		width = new TextFieldUtility(this, "幅", "80");
		height = new TextFieldUtility(this, "高さ", "80");
		fill = new ChoiceFieldUtility(this, "塗りつぶし", new String []{"なし", "塗りつぶし"});
		shape = new ChoiceFieldUtility(this, "図形", new String []{"円形", "四角形"});
		color = new ColorPickerUtility(this);
	}
	
	//描画(フレームごと)
	@Override public void paint(Graphics g){
		//円を表示(レンダリング)
		Figure f;
		System.out.println(objList.size());
		for(int i = objList.size() - 1; i >= 0; i --) {
			f = objList.get(i);
			f.paint(g);
		}
		
		//forの繰り返し条件が正しい限り不要
		//if(obj != null) obj.paint(g);
	}
	
	//イベント->マウスプレス
	@Override public void mousePressed(MouseEvent e){
		//図形
		int choice = shape.getChoice();
		if(choice == 0) {
			obj = new Circle();
		}else if(choice == 1) {
			obj = new Square();
		}
		//座標
		x = e.getX();
		y = e.getY();
		obj.moveto(x, y);
		//色をつける
		obj.setColor(color.getColor());
		//塗りつぶし
		obj.setFill(fill.getChoice() == 1);
		//サイズの指定
		obj.setSize(width.getValue(), height.getValue());
		//リストに追加
		objList.add(0, obj);
		
		//円の数が制限されているときは、古い円から削除
		if(size.getValue() != 0) {
			while(objList.size() > size.getValue()) {
				objList.remove((int)size.getValue());
			}
		}
		
		//表示(レンダリング)
		repaint();
	}
	//イベント->マウスリリース
	@Override public void mouseReleased(MouseEvent e){}
	@Override public void mouseClicked(MouseEvent e){}
	@Override public void mouseEntered(MouseEvent e){}
	@Override public void mouseExited(MouseEvent e){}
	@Override public void mouseDragged(MouseEvent e) {}
	@Override public void mouseMoved(MouseEvent e){}
}
