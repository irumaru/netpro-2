package ensyu2_2022;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import java.io.FileExtensionFilter;

public class Save extends ButtonUtility{
	ArrayList<Figure> objList;
	Frame frame;
	String filename;
	Load load;
	
	Save(Frame frame, ArrayList<Figure> objList, Load load){
		super(frame, "", "保存");
		this.frame = frame;
		this.objList = objList;
		this.load = load;
	}
	
	//上書き保存
	public void save(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objList);
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.err.println("ファイルへの書き込みに失敗しました。");
		}
	}
	
	//名前を付けて保存
	public void saveAs() {
		FileDialog file = new FileDialog(frame, "保存", FileDialog.SAVE);
		//file.setFileFilter(new FileNameExtensionFilter("PaintData(*.dat)", "dat"));
		if(load.path == null) {
			load.path = "*.dat"; //ファイル拡張子の表示(気休め程度)
		}
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
	
	@Override public void actionPerformed(ActionEvent e) {
		saveAs();
	}
}
