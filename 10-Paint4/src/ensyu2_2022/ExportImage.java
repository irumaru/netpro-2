package ensyu2_2022;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExportImage extends ButtonUtility{
	Frame frame;
	
	ExportImage(Frame frame){
		super(frame, "", "画像に出力");
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		BufferedImage image = new BufferedImage(frame.getSize().width, frame.getSize().height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		
		frame.paint(g);
		
		FileDialog file = new FileDialog(frame, "画像に保存", FileDialog.SAVE);
		file.setFile("*.png");
		file.setVisible(true);//表示&入力待ち
		
		//パスが指定されなかった時
		if(file.getFile() == null) {
			return;
		}
		
		//パスの生成
		String path = file.getDirectory() + file.getFile();
		
		try {
			ImageIO.write(image, "png", new File(path));
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			//System.err.println(e1);
			e1.printStackTrace();
		}
	}
}
