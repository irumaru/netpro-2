package ensyu2_2022;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Load extends ButtonUtility{
	ArrayList<Figure> objList;
	Frame frame;
	String path;
	
	Load(Frame frame, ArrayList<Figure> objList){
		super(frame, "", "読み込み");
		this.frame = frame;
		this.objList = objList;
	}
	
	@SuppressWarnings("unchecked")
	
	//obj
	public void load(String fname) {
		try {
			FileInputStream fis = new FileInputStream(fname);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Figure> objList = (ArrayList<Figure>)ois.readObject();
			ois.close();
			fis.close();
			this.objList.clear();
			this.objList.addAll(objList);
		}catch(IOException e) {
		}catch(ClassNotFoundException e) {
		}
		
		//再描画
		frame.repaint();
	}
	
	public void load() {
		FileDialog file = new FileDialog(frame, "読み込み", FileDialog.LOAD);
		file.setVisible(true);//表示&入力待ち
		
		//パスが指定されなかった時
		if(file.getFile() == null) {
			return;
		}
		
		//パスの生成
		String path = file.getDirectory() + file.getFile();
		
		load(path);
		this.path = path;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		load();
	}
}
