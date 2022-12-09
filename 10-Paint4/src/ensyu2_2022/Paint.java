package ensyu2_2022;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


//フレームオブジェクトを継承した、Paintクラスを宣言
public class Paint extends Frame implements MouseListener,MouseMotionListener, ActionListener{
	//FigureインスタンスとFigureクラスを継承したクラスのインスタンスを格納するリスト状のプロパティを、ArrayList型で宣言
	//全ての図形は、objListへ格納される
	ArrayList<Figure> objList;
	//図形の基準点x,yプロパティを宣言
	int x, y;
	
	//CheckboxGroup cbg; //メニュー
	//Checkbox c1, c2, c3, c4; //メニューの要素
	//Button end; //終了ボタン
	int mode = 0; //描画モード(1: 1点指定図形, 2: 2点指定図形)
	
	//上記と同じインスタンスを格納するプロパティを宣言
	//実際に描画する図形
	Figure obj;
	
	//描画時刻
	long now, old;
	
	//※1で利用するプロパティを宣言
	// TextFieldUtility size;
	// TextFieldUtility width;
	// TextFieldUtility height;
	ChoiceFieldUtility fill;
	ChoiceFieldUtility shape;
	ColorPickerUtility color;
	UndoButton undo;
	RedoButton redo;
	
	Image offImage;
	
	//mainクラスメソッドを宣言(起動時に実行される)
	public static void main(String[] args){
		//ペイントインスタンスを作成して格納
		Paint f = new Paint();
		//ウィンドウサイズを設定
		f.setSize(800,600);
		//画面上の設定メニューを中央上から配置するように指定
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		//ウィンドウのタイトルを設定
		f.setTitle("ペイントアプリ");
		//終了時の処理を設定
		f.addWindowListener(new WindowAdapter(){
			@Override public void windowClosing(WindowEvent e){
				System.exit(0);
			}});
		//ウィンドウの表示
		f.setVisible(true);
		//ファイル読み込み
		//if(args.length == 1)
			//f.load(args[0]);
		f.load("paint.dat");
	}
	
	//コンストラクタの宣言(Paintインスタンス作成時に実行される)
	Paint(){
		//Figure型のインスタンスをリスト上に格納できるArrayListインスタンスを作成し、objListプロパティへ代入
		objList = new ArrayList<Figure>();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		//this.offImage = createImage(800, 600); //イメージバッファ生成

		//setLayout(null);
		//画面作成
		/*
		cbg = new CheckboxGroup(); //Checkboxの集合を作成
		c1 = new Checkbox("丸", cbg, true); //丸メニューの作成
		c1.setBounds(560, 30, 60, 30); //丸メニューの座標指定
		add(c1); //丸メニューの追加
		
		c2 = new Checkbox("円", cbg, false);
		c2.setBounds(560, 60, 60, 30);
		add(c2);
		
		c3 = new Checkbox("四角", cbg, false);
		c3.setBounds(560, 90, 60, 30);
		add(c3); 
		
		c4 = new Checkbox("線", cbg, false);
		c4.setBounds(560, 120, 60, 30);
		add(c4);
		
		end = new Button("終了");
		end.setBounds(560, 300, 60, 30);
		add(end);
		*/
		
		//※1で用意したプロパティへ、各種インスタンスを代入
		
		//画面上に最大図形数の設定項目を追加
		//初期値は0であり、0は無制限を意味する。
		// size = new TextFieldUtility(this, "オブジェクト数", "0");
		//画面上に図形の幅の設定項目を追加
		// width = new TextFieldUtility(this, "幅", "80");
		//画面上に図形の高さの設定項目を追加
		// height = new TextFieldUtility(this, "高さ", "80");
		//画面上に塗りつぶしの設定項目を追加
		//引数でメニュー内容を指示
		fill = new ChoiceFieldUtility(this, "塗りつぶし", new String []{"なし", "塗りつぶし"});
		//画面上に図形の設定項目を追加
		shape = new ChoiceFieldUtility(this, "図形", new String []{"円", "楕円", "四角", "線"});
		//画面上にカラーピッカーを開いて色を選択するボタンを追加
		color = new ColorPickerUtility(this);
		//Undo
		undo = new UndoButton(this, objList);
		//Redo
		redo = new RedoButton(this, objList, undo.undoObjList); 
		
		//終了ボタン処理の登録
		//end.addActionListener(this);
		
		//描画時刻の初期化
		now = old = 0;
	}
	
	public void save(String fname) {
		try {
			FileOutputStream fos = new FileOutputStream(fname);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objList);
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.err.println("ファイルへの書き込みに失敗しました。");
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public void load(String fname) {
		try {
			FileInputStream fis = new FileInputStream(fname);
			ObjectInputStream ois = new ObjectInputStream(fis);
			objList = (ArrayList<Figure>)ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
		}catch(ClassNotFoundException e) {
		}
		
		//再描画
		repaint();
	}
	
	//描画(フレームごと)
	@Override public void paint(Graphics g){
		//ダブルバッファリング
		//http://www.gamesite8.com/archives/615401.html
		
		//イメージバッファ生成
		offImage = createImage(800, 600);
		Graphics gv = offImage.getGraphics();
		//ウィンドウに合わせて四角で初期化
		gv.clearRect(0,  0, 800, 600);
		
		//各種図形を描画
		Figure f;
		for(int i = 0; i < objList.size(); i ++) {
			f = objList.get(i);
			f.paint(gv);
		}
		
		if(mode >= 1) obj.paint(gv);
		
		//バッファされたイメージを描画
		g.drawImage(offImage, 0, 0, 800, 600, this);
		
	}
	
	//終了ボタン
	@Override public void actionPerformed(ActionEvent e) {
		save("paint.dat");
		System.exit(0);
	}
	
	//押されたとき
	@Override public void mousePressed(MouseEvent e){
		//Warning ほぼ全て書き換え
		
		//Checkbox c;
		
		x = e.getX();
		y = e.getY();
		
		//c = cbg.getSelectedCheckbox(); //選択されたチェックボックスの取得
		Integer s = shape.getChoice();
		obj = null;
		
		if(s == 0) { //円
			mode = 2;
			obj = new Circle();
		}else if(s == 1) {
			mode = 2;
			obj = new Oval();
		}else if(s == 2) { //四角
			mode = 2;
			obj = new Rect();
		}else if(s == 3) { //線
			mode = 2;
			obj = new Line();
		}else {
			System.err.println("存在しない図形番号です。");
			System.exit(1);
		}
		
		if(obj != null) {
			obj.moveto(x, y);
			obj.setColor(color.getColor());
			obj.setFill(fill.getChoice() == 1);
			repaint();
		}
		
		//図形数を表示
		//System.out.println("オブジェクト数: " + objList.size());
		
		//ディバッグ
		//for(int i = 0; i < objList.size(); i ++) {
		//	System.out.println("i="+i+" width="+objList.get(i).getSize()[0]);
		//}
		System.out.println();
	}
	//離されたとき
	@Override public void mouseReleased(MouseEvent e){
		x = e.getX();
		y = e.getY();
		
		if(mode == 1)
			obj.moveto(x, y);
		else if(mode == 2)
			obj.setWH(x - obj.x, y - obj.y);
		
		if(mode >= 1) {
			objList.add(obj);//最後尾に追加
			obj = null;
		}
		
		mode = 0;
		
		repaint();
	}
	//クリックされた
	@Override public void mouseClicked(MouseEvent e){}
	//Windowに入った
	@Override public void mouseEntered(MouseEvent e){}
	//WIndowを出た
	@Override public void mouseExited(MouseEvent e){}
	//ボタンを押したまま移動
	@Override public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		if(mode == 1) {
			obj.moveto(x, y);
		}else if(mode == 2) {
			obj.setWH(x - obj.x, y - obj.y);//幅と高さの指定
		}
		
		//描画を安定させるため、FPSを制限
		now = System.currentTimeMillis();
		if(70 < this.now - this.old) {
			repaint();
			old = now;
		}
	}
	//移動
	@Override public void mouseMoved(MouseEvent e){}
}
