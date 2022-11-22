package ensyu2_2022;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

public class ColorPickerUtility extends ButtonUtility{
	Frame frame;
	Color color;
	
	ColorPickerUtility(Frame frame){
		super(frame, "色指定", "詳細");
		this.frame = frame;
		//色の初期値を設定
		this.color = new Color(100, 255, 255);
	}
	
	//スーパークラスで宣言されたアクションリスナーが実際に実行するメソッド
	@Override public void actionPerformed(ActionEvent e) {
		//カラーピッカーウィンドウを開き、色を選択
		Color color = JColorChooser.showDialog(this.frame, "色の選択", Color.white);
		
		//取り消しなどで色がカラーピッカーから取得できないとき
		if(color != null)
			this.color = color;
	}
	
	//ゲッター
	public Color getColor() {
		return this.color;
	}
}
