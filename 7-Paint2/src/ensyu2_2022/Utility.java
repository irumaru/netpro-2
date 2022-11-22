package ensyu2_2022;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Utility {
	//ラベルとインプットフィールドをセットにしたレイアウトを格納
	Panel panel;
	//ラベルを格納
	Label label;
	//ボタンを格納
	Button button;
	
	Utility(Frame frame, String labelName) {
		//インスタンスの作成
		panel = new Panel();
		//グリッドレイアウトで3行1列に設定
		panel.setLayout(new GridLayout(3, 1));
		
		//パネルをフレーム(描画する画面)に追加
		frame.add(panel);
		
		//ラベルの追加
		label = new Label(labelName);
		//ラベルをフレーム(描画する画面)に追加
		panel.add(label);
	}
}
