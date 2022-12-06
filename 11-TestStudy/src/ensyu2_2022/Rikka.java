package ensyu2_2022;

public class Rikka extends Takanasi{
	int r;
	
	Rikka(int a){
		super(10);
		System.out.println("立花");
		
		r = 10;
	}
	
	@Override public void fukyo() {
		super.fukyo(); //親メソッドを呼び出す
		System.out.println("不可視境界線はある");
	}
}
