package ensyu2_2022;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;

//import java.awt.FlowLayout;
import javax.swing.JColorChooser;

//import ensyu2_2022.ButtonUtility;

public class ColorPickerUtility extends ButtonUtility{
	Frame frame;
	Color color;
	
	ColorPickerUtility(Frame frame){
		super(frame, "色の選択", "詳細");
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		/*
		Frame f = new Frame();
		f.setSize(800,600);
		//f.setLayout(null);
		//f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.setTitle("カラーピッカー");
		f.addWindowListener(new WindowAdapter(){
			@Override public void windowClosing(WindowEvent e){
				System.exit(0);
			}});
		f.setVisible(true);
		*/
		//JColorChooser colorchooser = new JColorChooser();
		this.color = JColorChooser.showDialog(this.frame, "色の選択", Color.white);
	}
	
	public Color getColor() {
		return this.color;
	}
}
