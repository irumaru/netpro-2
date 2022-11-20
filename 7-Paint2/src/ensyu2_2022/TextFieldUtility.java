package ensyu2_2022;

import java.awt.Frame;
import java.awt.TextField;

public class TextFieldUtility extends Utility{
	TextField textField;
	
	TextFieldUtility(Frame frame, String labelName, String defaultValue){
		super(frame, labelName);
		
		textField = new TextField();
		textField.setText(defaultValue);//初期値
		
		panel.add(textField);
	}
	
	public Integer getValue() {
		return Integer.parseInt(textField.getText());
	}
}
