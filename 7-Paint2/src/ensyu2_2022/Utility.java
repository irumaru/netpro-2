package ensyu2_2022;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Utility {
	Panel panel;
	Label label;
	Button button;
	
	Utility(Frame frame, String labelName) {
		panel = new Panel();
		panel.setLayout(new GridLayout(3, 1));
		
		//パネルをフレームに追加
		frame.add(panel);
		
		//ラベルの追加
		label = new Label(labelName);
		panel.add(label);
	}
}
