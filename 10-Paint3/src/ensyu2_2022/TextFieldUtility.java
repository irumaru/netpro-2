package ensyu2_2022;

import java.awt.Frame;
import java.awt.TextField;

public class TextFieldUtility extends Utility{
	//テキストフィールドを格納
	TextField textField;
	
	TextFieldUtility(Frame frame, String labelName, String defaultValue){
		super(frame, labelName);
		
		textField = new TextField();
		//テキストフィールドに入力する初期値を設定
		textField.setText(defaultValue);
		
		//テキストフィールドをスーパークラスのインスタンスで宣言されたpanelに追加
		panel.add(textField);
	}
	
	//ゲッター
	public Integer getValue() {
		//文字列の数値を整数に変換
		return Integer.parseInt(textField.getText());
	}
}
