package ensyu2_2022;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonUtility extends Utility implements ActionListener{
	Button button;
	
	ButtonUtility(Frame frame, String labelName, String buttonName){
		super(frame, labelName);
		
		button = new Button(buttonName);
		button.addActionListener(this);
		
		panel.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
}
