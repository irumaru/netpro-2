package ensyu2_2022;

import java.awt.Choice;
import java.awt.Frame;

public class ChoiceFieldUtility extends Utility{
	Choice choice;
	
	ChoiceFieldUtility(Frame frame, String labelName, String[] list){
		super(frame, labelName);
		
		choice = new Choice();
		
		for(String select: list) {
			choice.add(select);
		}
		
		panel.add(choice);
	}
	
	public Integer getChoice() {
		return choice.getSelectedIndex();
	}
}
