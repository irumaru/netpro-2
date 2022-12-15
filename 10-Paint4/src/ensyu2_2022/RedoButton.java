package ensyu2_2022;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//ボタンが押されたらundoObjListの図形をobjListへ戻す
public class RedoButton extends ButtonUtility{
	ArrayList<Figure> objList;
	Integer objSize;
	UndoButton undo;
	Frame frame;
	
	RedoButton(Frame frame, ArrayList<Figure> objList, UndoButton undo) {
		//ボタンを追加
		super(frame, "", "Redo");
		this.objList = objList;
		this.undo = undo;
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		//順1 Undo後に図形が追加されていたら、UndoObjListを初期化
		if(undo.objSize != objList.size()) {
			undo.undoObjList.clear();
			//図形数の更新
			undo.objSize = objList.size();
		}
		//順2 undoObjListが1つ以上あるなら、undoしたものをredoする
		if(0 < undo.undoObjList.size()) {
			//undoObjListの最新の図形をobjListへコピー(参照)
			objList.add(undo.undoObjList.get(undo.undoObjList.size() - 1));
			undo.objSize = objList.size(); //add後
			//undoObjListの最新の参照を図形を削除
			undo.undoObjList.remove(undo.undoObjList.size() - 1);
			//再描画
			frame.repaint();
		}
	}
}
