package ensyu2_2022;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//ファイル書き込み
public class Save extends ButtonUtility{
	ArrayList<Figure> objList;
	Frame frame;
	String filename;
	Load load;
	
	Save(Frame frame, ArrayList<Figure> objList, Load load){
		//ボタンを追加
		super(frame, "", "保存");
		//再描画用
		this.frame = frame;
		this.objList = objList;
		this.load = load;
	}
	
	//pathで指定されたファイルへobjListを保存
	public void save(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//objListをファイル(ObjectStream)へ書き込み
			oos.writeObject(objList);
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.err.println("ファイルへの書き込みに失敗しました。");
		}
	}
	
	//ダイアログを使用してファイルを書き込む
	public void saveAs() {
		//ファイルダイアログを書き込みモードで表示
		FileDialog file = new FileDialog(frame, "保存", FileDialog.SAVE);
		//Loadされていなく、load.pathプロパティ(読み込み時のパス)が空の時
		if(load.path == null) {
			load.path = "*.dat"; //ファイル拡張子の表示(気休め程度)
		}
		//ダイアログへ候補(デフォルト)として表示するパスを指定
		file.setFile(load.path);
		file.setVisible(true);//表示&入力待ち
		
		//パスが指定されなかった時
		if(file.getFile() == null) {
			return;
		}
		
		//パスの生成
		String path = file.getDirectory() + file.getFile();
		
		save(path);
	}
	
	//クリックしてファイル書き込み
	@Override public void actionPerformed(ActionEvent e) {
		saveAs();
	}
}
