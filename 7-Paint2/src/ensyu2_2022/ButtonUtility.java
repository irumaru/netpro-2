package ensyu2_2022;

import java.awt.Button;
import java.awt.Frame;

public class ButtonUtility extends Utility{
	Button button;
	
	ButtonUtility(Frame frame, String labelName, String buttonName){
		super(frame, labelName);
		
		button = new Button(buttonName);
		button.addActionListener(this);
		
		panel.add(button);
	}
}
