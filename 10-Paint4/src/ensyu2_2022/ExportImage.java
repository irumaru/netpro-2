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
		//ボタンを追加
		super(frame, "", "画像に出力");
		
		this.frame = frame;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		//RGBモードで画面サイズの空の画像を作成
		BufferedImage image = new BufferedImage(frame.getSize().width, frame.getSize().height, BufferedImage.TYPE_INT_RGB);
		//上記から、Graphicsインスタンスを取得
		Graphics g = image.getGraphics();
		
		//生成したgインスタンスに、図形を描画(Paintインスタンスのpaintメソッドを指定)
		frame.paint(g);
		
		//ファイルダイアログをSAVEモードで開く
		FileDialog file = new FileDialog(frame, "画像に保存", FileDialog.SAVE);
		//ファイル名がpngであることを示す
		file.setFile("*.png");
		//表示&入力待ち
		file.setVisible(true);
		
		//パスが指定されなかった時
		if(file.getFile() == null) {
			return;
		}
		
		//パスの生成
		String path = file.getDirectory() + file.getFile();
		
		//画像の書き出し
		try {
			//imageをpngファイル形式でpathへ書き込み
			ImageIO.write(image, "png", new File(path));
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}
}
