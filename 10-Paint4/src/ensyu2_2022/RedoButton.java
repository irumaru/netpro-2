package ensyu2_2022;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RedoButton extends ButtonUtility{
	ArrayList<Figure> objList;
	ArrayList<Figure> undoObjList;
	Frame frame;
	
	RedoButton(Frame frame, ArrayList<Figure> objList, ArrayList<Figure> undoObjList) {
		super(frame, "", "Redo");
		this.objList = objList;
		this.undoObjList = undoObjList;
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(undoObjList.size() != 0) {
			//ディバッグ
			//for(int i = 0; i < undoObjList.size(); i ++) {
			//	System.out.println("i="+i+" width="+undoObjList.get(i).getSize()[0]);
			//}
			objList.add(undoObjList.get(undoObjList.size() - 1));
			undoObjList.remove(undoObjList.size() - 1);
			frame.repaint();
		}
	}
}
