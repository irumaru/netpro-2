package ensyu2_2022;

public class ArgsTest4 {
	int no;
	public static void main(String[] args) {
		int i = 2132999;
		ArgsTest4 koudai = new ArgsTest4();
		koudai.setNo(i);
		System.out.println("1: no = " + koudai.no + " i = " + i);
		koudai.setNo(2132088);
		System.out.println("2: no = " + koudai.no + " i = " + i);
	}
	public void setNo(int no) {
		this.no = no;//原則近くで宣言したものが参照される
		no ++;
	}
}
