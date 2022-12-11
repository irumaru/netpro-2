package ensyu2_2022;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ClearButton extends ButtonUtility{
	ArrayList<Figure> objList;
	Frame frame;
	
	ClearButton(Frame frame, ArrayList<Figure> objList){
		super(frame, "", "初期化");
		this.objList = objList;
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		objList.clear();
		frame.repaint();
	}
}
