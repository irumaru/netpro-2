package ensyu2_2022;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//ボタンが押されるとobjListから最新の図形を削除して、undoObjListに追加する
public class UndoButton extends ButtonUtility{
	ArrayList<Figure> objList;
	ArrayList<Figure> undoObjList;
	Integer objSize;
	Frame frame;
	
	UndoButton(Frame frame, ArrayList<Figure> objList) {
		//ボタンを追加
		super(frame, "", "Undo");
		//objListを取得
		this.objList = objList;
		//undoObjListの初期化
		this.undoObjList = new ArrayList<Figure>();
		//再描画用
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(objList.size() != 0) {//objListに図形が存在するとき
			//objListの最新の図形を、undoObjListへコピー(参照)
			undoObjList.add(objList.get(objList.size() - 1));
			//objListの最新の図形の参照を削除
			objList.remove(objList.size() - 1);
			//図形数を更新(Redoで使用)
			objSize = objList.size();//remove後
			//再描画
			frame.repaint();
		}
	}
}
