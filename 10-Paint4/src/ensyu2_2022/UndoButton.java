package ensyu2_2022;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UndoButton extends ButtonUtility{
	ArrayList<Figure> objList;
	Frame frame;
	
	UndoButton(Frame frame, ArrayList<Figure> objList) {
		super(frame, "", "Undo");
		this.objList = objList;
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		objList.remove(objList.size() - 1);
		frame.repaint();
	}
}
