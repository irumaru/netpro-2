package ensyu2_2022;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

//ファイル読み込み用
public class Load extends ButtonUtility{
	ArrayList<Figure> objList;
	Paint frame;
	String path;
	
	Load(Paint frame, ArrayList<Figure> objList){
		super(frame, "", "読み込み");
		//再描画用にPaintの参照を取得
		this.frame = frame;
		//onjListの参照を取得
		this.objList = objList;
	}
	
	@SuppressWarnings("unchecked")
	
	//pathにあるファイルを読み込んで、objListへ挿入
	public void load(String path) {
		try {
			//パスからファイルStreamを取得
			FileInputStream fis = new FileInputStream(path);
			//ファイルからオブジェクトStreamを取得
			ObjectInputStream ois = new ObjectInputStream(fis);
			//取得したオブジェクトをobjList変数へ代入
			ArrayList<Figure> objList = (ArrayList<Figure>)ois.readObject();
			//各種Streamを閉じる
			ois.close();
			fis.close();
			//objListを初期化する
			this.objList.clear();
			//objListへ取得したobjListを挿入
			this.objList.addAll(objList);
		}catch(IOException e) {
			//例外 未対応のファイル形式
			System.err.println("このファイルは読み込めません。");
		}catch(ClassNotFoundException e) {
			//例外
			System.err.println("ファイルの読み込みに失敗しました。");
		}
		
		//再描画
		frame.forceRepaint();
	}
	
	//ダイアログを使用してファイルを読み込む
	public void load() {
		//ファイルダイアログを読み込みモードで表示
		FileDialog file = new FileDialog(frame, "読み込み", FileDialog.LOAD);
		file.setVisible(true);//表示&入力待ち
		
		//ファイル名が指定されなかった時
		if(file.getFile() == null) {
			return;
		}
		
		//パスの生成
		String path = file.getDirectory() + file.getFile();
		
		//ファイルを読み込み
		load(path);
		
		//上書き保存用にpathを保存
		this.path = path;
	}
	
	//クリックしてファイル読み込み
	@Override public void actionPerformed(ActionEvent e) {
		load();
	}
}
