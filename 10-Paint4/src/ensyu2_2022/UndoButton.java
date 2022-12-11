package ensyu2_2022;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UndoButton extends ButtonUtility{
	ArrayList<Figure> objList;
	ArrayList<Figure> undoObjList;
	Integer objSize;
	Frame frame;
	
	UndoButton(Frame frame, ArrayList<Figure> objList) {
		super(frame, "", "Undo");
		this.objList = objList;
		this.undoObjList = new ArrayList<Figure>();
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(objList.size() != 0) {
			undoObjList.add(objList.get(objList.size() - 1));
			objList.remove(objList.size() - 1);
			objSize = objList.size();//remove後
			System.out.println(objSize);
			frame.repaint();
		}
	}
}
