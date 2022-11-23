package ensyu2_2022;

import java.awt.Choice;
import java.awt.Frame;

public class ChoiceFieldUtility extends Utility{
	//選択フィールドを格納
	Choice choice;
	
	ChoiceFieldUtility(Frame frame, String labelName, String[] list){
		super(frame, labelName);
		
		choice = new Choice();
		
		//list配列に格納した選択肢をchoiceへ追加
		for(String select: list) {
			choice.add(select);
		}
		
		panel.add(choice);
	}
	
	public Integer getChoice() {
		//list配列に格納された選択肢のうち何番目のものが選択されたかを返す
		return choice.getSelectedIndex();
	}
}
