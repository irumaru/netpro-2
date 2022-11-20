package ensyu2_2022;

public class ArgsTest6 {
	int no;
	static int count = 0;
	public static void setNo(ArgsTest6 student, int no) {
		student.no = no;
		student.no++;
		student = new ArgsTest6();
		student.no = 2132777;
	}
	ArgsTest6(){
		count++;
	}
}
