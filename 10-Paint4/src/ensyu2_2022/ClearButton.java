package ensyu2_2022;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

//全ての図形を削除する
public class ClearButton extends ButtonUtility{
	ArrayList<Figure> objList;
	Paint frame;
	
	ClearButton(Paint frame, ArrayList<Figure> objList){
		//ボタンを追加
		super(frame, "", "初期化");
		
		this.objList = objList;
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		//全ての図形を削除
		objList.clear();
		//画面を更新
		frame.forceRepaint();
	}
}
