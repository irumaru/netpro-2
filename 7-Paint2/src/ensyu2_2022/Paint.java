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
		
		//JColorChooser colorchooser = new JColorChooser();
		//Color color = colorchooser.showDialog(this, "色の選択", Color.white);
		
		//System.out.println(color);
	}
	
	//描画(フレームごと)
	@Override public void paint(Graphics g){
		//設定(仮)
		int objLimitCount = size.getValue();//最大表示オブジェクト数 0で制限なし
		boolean objCountOut = true;
		
		//初期化
		
		
		
		//円の表示数をカウント
		if(objLimitCount == 0)
			objPrintCount = objList.size();
		else if(objLimitCount < objList.size())
			objPrintCount = objLimitCount;
		else
			objPrintCount = objList.size();
		
		//円を表示(レンダリング)
		Figure f;
		for(int i = 0; i < objPrintCount; i ++) {
			f = objList.get(i);
			f.paint(g);
		}
		
		//何してるのか不明
		//if(obj != null) obj.paint(g);
		
		//コンソール出力
		if(objCountOut)
			System.out.printf("制限: %d個\n図形: %d\n", objPrintCount, shape.getChoice());
		
		//プリントディバッグ
		//System.out.printf("最後の円のサイズ: %d\n", tmp);
	}
	
	//イベント->マウスプレス
	@Override public void mousePressed(MouseEvent e){
		/*
		x = e.getX();
		y = e.getY();
		obj = new Circle();
		obj.moveto(x, y);
		repaint();
		*/
		
		//円
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
		//100,255,255 リムル
		obj.setColor(color.getColor());
		
		//塗りつぶし
		obj.setFill(fill.getChoice() == 1);
		
		//サイズの指定
		obj.setSize(width.getValue(), height.getValue());
		
		//リストに追加
		objList.add(0, obj);
		
		//表示(レンダリング)
		repaint();
	}
	//イベント->マウスリリース
	@Override public void mouseReleased(MouseEvent e){
		/*
		x = e.getX();
		y = e.getY();
		obj.moveto(x, y);
		objList.add(obj);
		obj = null;
		repaint();
		*/
		
		/*
		//離したとき
		x = e.getX();
		y = e.getY();
		obj = new Circle();
		obj.moveto(x, y);
		objList.add(0, obj);
		repaint();
		*/
	}
	@Override public void mouseClicked(MouseEvent e){}
	@Override public void mouseEntered(MouseEvent e){}
	@Override public void mouseExited(MouseEvent e){}
	//イベント->マウスドラッグ
	@Override public void mouseDragged(MouseEvent e) {
		/*
		x = e.getX();
		y = e.getY();
		if(obj != null) obj.moveto(x, y);
		repaint();
		*/
		
		/*
		//連続
		x = e.getX();
		y = e.getY();
		obj = new Circle();
		obj.moveto(x, y);
		objList.add(0, obj);
		repaint();
		*/
	}
	@Override public void mouseMoved(MouseEvent e){}
}
