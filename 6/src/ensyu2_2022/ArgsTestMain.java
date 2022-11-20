package ensyu2_2022;

public class ArgsTestMain {
	public static void main(String[] args) {
		int i = 2132999;
		ArgsTest6 koudai = new ArgsTest6();
		ArgsTest6.setNo(koudai, i);
		System.out.println("1: no = " + koudai.no + " i = " + i + " count = " + ArgsTest6.count);
		ArgsTest6.setNo(koudai, 2132888);
		System.out.println("2: no = " + koudai.no + " i = " + i + " count = " + ArgsTest6.count);
		ArgsTest6.setNo(koudai, 2132888);
		System.out.println("2: no = " + koudai.no + " i = " + i + " count = " + ArgsTest6.count);
	}
}
