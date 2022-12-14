package ensyu2_2022;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


//フレームオブジェクトを継承した、Paintクラスを宣言
public class Paint extends Frame implements MouseListener,MouseMotionListener{
	//Figureインスタンスと、Figureクラスを継承したクラスのインスタンスを格納するリスト状のプロパティを、ArrayList型で宣言
	//全ての図形は、objListへ格納される
	ArrayList<Figure> objList;
	
	//描画する図形のインスタンス
	Figure obj;
	
	//図形の基準点x,yプロパティを宣言
	int x, y;
	
	//描画モード(0:未指定, 1: 1点指定図形, 2: 2点指定図形, 3: n点指定)
	int mode = 0;
	
	//図形移動時に、選択された(移動している)図形を格納
	//nullで未選択
	Figure objSelect = null;
	//図形の基準点とクリック点の差を格納
	int objDifferenceX = 0;
	int objDifferenceY = 0;
	
	//直近のクリックした時間(ダブルクリック判定用)
	long latestClick = 0;
	
	//レンダリング改善用
	//描画時刻
	long now, old;
	//画面サイズ(変更時のみバッファ用インスタンスを初期化することで軽量化)
	Integer width, height, oldWidth, oldHeight;
	//ダブルバッファリング用バッファ
	private Image offImage;
	private Graphics gv;
	
	//操作ボタン ※1
	//操作モード(描画or移動)
	ChoiceFieldUtility operation;
	//塗りつぶしの有無
	ChoiceFieldUtility fill;
	//描画する図形の形状
	ChoiceFieldUtility shape;
	//色の選択
	ColorPickerUtility color;
	//戻る
	UndoButton undo;
	//「戻る」を取り消し
	RedoButton redo;
	//初期化
	ClearButton clear;
	//ファイルに保存
	Save save;
	//ファイルから読み込み
	Load load;
	//画像ファイルへ出力
	ExportImage export;
	
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
	}
	
	//コンストラクタの宣言(Paintインスタンス作成時に実行される)
	Paint(){
		//Figure型のインスタンスをリスト上に格納できるArrayListインスタンスを作成し、objListプロパティへ代入
		objList = new ArrayList<Figure>();
		
		//マウス系イベントの登録
		addMouseListener(this);
		addMouseMotionListener(this);

		//※1で用意したプロパティへ、インスタンスを作成し代入
		//操作方法を選択
		operation = new ChoiceFieldUtility(this, "操作", new String []{"描画", "移動"});
		//引数でメニュー内容を指示
		fill = new ChoiceFieldUtility(this, "塗りつぶし", new String []{"なし", "塗りつぶし"});
		//画面上に図形の設定項目を追加
		shape = new ChoiceFieldUtility(this, "図形", new String []{"丸", "円", "楕円", "四角", "多角形", "線", "折れ線"});
		//画面上にカラーピッカーを開いて色を選択するボタンを追加
		color = new ColorPickerUtility(this);
		//Undo
		undo = new UndoButton(this, objList);
		//Redo
		redo = new RedoButton(this, objList, undo);
		//Clear
		clear = new ClearButton(this, objList);
		//Load
		load = new Load(this, objList);
		//Save
		save = new Save(this, objList, load);
		//ExportImage
		export = new ExportImage(this);
		
		//描画時刻の初期化
		now = old = 0;
		
		//画面サイズの初期化(ダブルバッファリングで使用)
		width = height = 0;
	}
	
	//描画(フレームごと)
	@Override public void paint(Graphics g){
		//ダブルバッファリング
		//http://www.gamesite8.com/archives/615401.html
		
		//現在の画面サイズと、1つ前の画面サイズを保持
		oldWidth = width;
		oldHeight = height;
		//getSize()で現在の画面サイズを取得
		width = getSize().width;
		height = getSize().height;
		
		//イメージバッファ生成
		//初回実行又は、画面サイズ変更時のみ、バッファを初期化
		if(offImage == null || !height.equals(oldHeight) || !width.equals(oldWidth)) {
			offImage = createImage(width, height);
			gv = offImage.getGraphics();
		}
		
		//ウィンドウサイズに合わせて四角で初期化
		gv.clearRect(0, 0, width, height);
		
		//各種図形を描画
		Figure f;
		for(int i = 0; i < objList.size(); i ++) {
			//ArrayList型objListから、描画する図形を取得
			f = objList.get(i);
			//取得した図形をバッファへ描画
			f.paint(gv);
			
			//移動用、図形が選択されているときは、図形の外側に四角を表示
			if(objSelect == f) {
				f.printOutline(gv);
			}
		}
		
		//描画中の図形を表示
		if(mode >= 1) obj.paint(gv);
		
		//バッファされたイメージを画面に表示
		g.drawImage(offImage, 0, 0, width, height, this);
	}
	
	//描画を安定させるため、FPSを制限
	@Override public void repaint() {
		//現在時刻を取得
		now = System.currentTimeMillis();
		//前回の描画から33ms以上経過
		if(33 < this.now - this.old) {
			//時刻をシフト
			old = now;
			//描画
			super.repaint();
		}
	}
	
	//必ず表示される必要があるとき
	public void forceRepaint() {
		super.repaint();
	}
	
	//押されたとき
	@Override public void mousePressed(MouseEvent e){
		//カーソルがある座標を取得
		x = e.getX();
		y = e.getY();
		
		//操作の種類を取得
		int o = operation.getChoice();
		
		if(o == 0) {//図形描画モード
			if(mode == 3) {//n点指定図形の点追加モード
				//ダブルクリック(2回目)で描画終了
				if(System.currentTimeMillis() - latestClick < 300) {
					//描画なし
					mode = 0;
					objList.add(obj);
					obj = null;
				}else{
					latestClick = System.currentTimeMillis();
					
					//点の追加
					obj.addCoord(x, y);
				}
			}else if(mode == 0) {
				//描画開始
				Integer s = shape.getChoice();
				
				if(s == 0) {//描画
					mode = 1;
					obj = new Dot();
				}else if(s == 1) { //円
					mode = 2;
					obj = new Circle();
				}else if(s == 2) {//楕円
					mode = 2;
					obj = new Oval();
				}else if(s == 3) { //四角
					mode = 2;
					obj = new Rect();
				}else if(s == 4) {//多角形
					mode = 3;
					obj = new Polygon();
				}else if(s == 5) { //線
					mode = 2;
					obj = new Line();
				}else if(s == 6) { //折れ線
					mode = 3;
					obj = new Polyline();
				}else {
					System.err.println("存在しない図形番号です。");
					System.exit(1);
				}
				
				if(obj != null) {
					//図形の基準点を、クリックした座標に指定
					obj.moveto(x, y);
					//図形の色を、選択した色に指定
					obj.setColor(color.getColor());
					//図形の塗りつぶしの指定
					obj.setFill(fill.getChoice() == 1);
				}
			}
		}else if(o == 1) {//移動モード
			//一時的な図形の格納
			Figure objt;
			//クリックした座標にある図形を探す
			for(int i = 0; i < objList.size(); i ++) {
				//図形の取得
				objt = objList.get(i);
				
				//図形の外周の左上の座標を取得
				int ox = objt.getOutlineX();
				int oy = objt.getOutlineY();
				//図形の外周の大きさを取得
				int ow = objt.getOutlineW();
				int oh = objt.getOutlineH();
				
				//マウスの位置が図形の範囲内か？
				if(ox < x && x < ox + ow && oy < y && y < oy + oh) {
					//図形の基準点とクリックした座標の差を取得
					objDifferenceX = objt.x - x;
					objDifferenceY = objt.y - y;
					//objSelect(選択した図形)に格納
					objSelect = objt;
					//クリックした直下の図形が見つかったので、探索を終了
					break;
				}
			}
		}
		
		//再描画
		forceRepaint();
	}
	//離されたとき
	@Override public void mouseReleased(MouseEvent e){
		x = e.getX();
		y = e.getY();
		
		int o = operation.getChoice();
		
		if(o == 0) {//図形描画モード
			if(mode == 1) {//1点指定図形
				obj.moveto(x, y);
			}else if(mode == 2) {//2点指定図形
				//横幅と縦幅を指定
				obj.setWH(x - obj.x, y - obj.y);
			}
			
			if(mode == 1 || mode == 2) {//1点と2点指定図形
				//図形を保存して、描画を終了
				objList.add(obj);
				obj = null;
				mode = 0;
			}
		}else if(o == 1) {//図形移動モード
			//移動終了
			//図形を移動(マウスのクリック座標と図形の基準点の差も考慮)
			objSelect.moveto(x + objDifferenceX, y + objDifferenceY);
			objSelect = null;
		}
		
		//再描画
		forceRepaint();
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
		
		int o = operation.getChoice();
		
		if(o == 0) {//図形描画モード
			if(mode == 1) {//1点指定図形
				obj.moveto(x, y);
			}else if(mode == 2) {//2点指定図形
				obj.setWH(x - obj.x, y - obj.y);
			}
		}else if(o == 1) {//図形移動モード
			//図形が選択されているとき
			if(objSelect != null) {
				objSelect.moveto(x + objDifferenceX, y + objDifferenceY);
			}
		}
		
		//再描画(FPS制限あり)
		repaint();
	}
	//移動
	@Override public void mouseMoved(MouseEvent e){
		x = e.getX();
		y = e.getY();
		
		if(mode == 3) {//n点指定図形
			//基準点としては追加しないが、図形作成中にわかりやすくカーソルを追尾する
			obj.addVirtualCoord(x, y);
			//再描画(FPS制限あり)
			repaint();
		}
	}
}
