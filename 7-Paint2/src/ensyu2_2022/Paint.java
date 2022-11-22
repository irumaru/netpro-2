package ensyu2_2022;

//各種必要な機能の読み込み
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

//フレームオブジェクトを継承した、Paintクラスを宣言
public class Paint extends Frame implements MouseListener,MouseMotionListener {
	//FigureインスタンスとFigureクラスを継承したクラスのインスタンスを格納するリスト状のプロパティを、ArrayList型で宣言
	//全ての図形は、objListへ格納される
	ArrayList<Figure> objList;
	//上記と同じインスタンスを格納するプロパティを宣言
	Figure obj;
	//図形の基準点x,yプロパティを宣言
	int x, y;
	
	//※1で利用するプロパティを宣言
	TextFieldUtility size;
	TextFieldUtility width;
	TextFieldUtility height;
	ChoiceFieldUtility fill;
	ChoiceFieldUtility shape;
	ColorPickerUtility color;
	
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
		f.setVisible(true);
	}
	
	//コンストラクタの宣言(Paintインスタンス作成時に実行される)
	Paint(){
		//Figure型のインスタンスをリスト上に格納できるArrayListインスタンスを作成し、objListプロパティへ代入
		objList = new ArrayList<Figure>();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		
		//※1で用意したプロパティへ、各種インスタンスを代入
		
		//画面上に最大図形数の設定項目を追加
		//初期値は0であり、0は無制限を意味する。
		size = new TextFieldUtility(this, "オブジェクト数", "0");
		//画面上に図形の幅の設定項目を追加
		width = new TextFieldUtility(this, "幅", "80");
		//画面上に図形の高さの設定項目を追加
		height = new TextFieldUtility(this, "高さ", "80");
		//画面上に塗りつぶしの設定項目を追加
		//引数でメニュー内容を指示
		fill = new ChoiceFieldUtility(this, "塗りつぶし", new String []{"なし", "塗りつぶし"});
		//画面上に図形の設定項目を追加
		shape = new ChoiceFieldUtility(this, "図形", new String []{"円形", "四角形"});
		//画面上にカラーピッカーを開いて色を選択するボタンを追加
		color = new ColorPickerUtility(this);
	}
	
	//描画(フレームごと)
	@Override public void paint(Graphics g){
		//各種図形を格納
		Figure f;
		//objListをIndexが大きい方から順番に描画
		//大きい方から描画することで、最も最近追加した図形が一番上に表示される
		for(int i = objList.size() - 1; i >= 0; i --) {
			f = objList.get(i);
			f.paint(g);
		}
	}
	
	//マウスを押したときにイベント駆動するメソッド
	@Override public void mousePressed(MouseEvent e){
		//このメソッド内のコメントの「取得」は、画面上の設定項目で設定された値を取得するものとする
		
		//現在選択されている図形を取得する
		//shapeインスタンス作成時のChoiceFieldUtilityクラスの第3引数の配列の順番が返される
		int choice = shape.getChoice();
		if(choice == 0) {
			//円の図形のCircleインスタンスの作成
			obj = new Circle();
		}else if(choice == 1) {
			//四角形の図形のSquareインスタンスの作成
			obj = new Square();
		}
		//クリックされた座標を取得
		x = e.getX();
		y = e.getY();
		//クリックされた座標に図形の基準点を設定
		obj.moveto(x, y);
		//現在選択されている色を取得して、図形に設定
		obj.setColor(color.getColor());
		//塗りつぶしの有無を取得して、図形に設定
		obj.setFill(fill.getChoice() == 1);
		//現在設定されているサイズを取得して、図形に設定
		obj.setSize(width.getValue(), height.getValue());
		//objListの0番目に追加
		objList.add(0, obj);
		
		//図形の数が制限されているときは、古い図形から削除
		//最大図形数が制限されているか
		if(size.getValue() != 0) {
			//現在objListに格納されている図形数は制限値以下であるか
			while(objList.size() > size.getValue()) {
				//図形の削除
				//Integerからintへキャスト
				objList.remove((int)size.getValue());
			}
		}
		
		//図形数を表示
		System.out.println("オブジェクト数: " + objList.size());
		
		//画面に描画
		repaint();
	}
	
	//未使用のマウス系イベント
	@Override public void mouseReleased(MouseEvent e){}
	@Override public void mouseClicked(MouseEvent e){}
	@Override public void mouseEntered(MouseEvent e){}
	@Override public void mouseExited(MouseEvent e){}
	@Override public void mouseDragged(MouseEvent e) {}
	@Override public void mouseMoved(MouseEvent e){}
}
