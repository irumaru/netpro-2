package ensyu2_2022;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RedoButton extends ButtonUtility{
	ArrayList<Figure> objList;
	Integer objSize;
	UndoButton undo;
	Frame frame;
	
	RedoButton(Frame frame, ArrayList<Figure> objList, UndoButton undo) {
		super(frame, "", "Redo");
		this.objList = objList;
		this.undo = undo;
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		//順1 Undo後に図形が追加されていたら、UndoObjListを初期化
		if(undo.objSize != objList.size()) {
			System.out.printf("undoObjList %d個のデータを削除\n", undo.undoObjList.size());
			undo.undoObjList.clear();
			undo.objSize = objList.size();
		}
		//順2 undoObjListが1つ以上あるなら、undoしたものをredoする
		if(0 < undo.undoObjList.size()) {
			//ディバッグ
			//for(int i = 0; i < undoObjList.size(); i ++) {
			//	System.out.println("i="+i+" width="+undoObjList.get(i).getSize()[0]);
			//}
			objList.add(undo.undoObjList.get(undo.undoObjList.size() - 1));
			undo.objSize = objList.size(); //add後
			undo.undoObjList.remove(undo.undoObjList.size() - 1);
			frame.repaint();
		}
	}
}
