package ensyu2_2022;

public class ArgsTest5 {
	int no;
	public static void main(String[] args) {
		int i = 2132999;
		ArgsTest5 koudai = new ArgsTest5();
		ArgsTest5.setNo(koudai, i);
		System.out.println("1: no = " + koudai.no + " i = " + i);
		ArgsTest5.setNo(koudai, 2132088);
		System.out.println("2: no = " + koudai.no + " i = " + i);
	}
	public static void setNo(ArgsTest5 student, int no) {
		student.no = no;
		student.no++;
		student = new ArgsTest5();
		student.no = 21320777;
	}
}
