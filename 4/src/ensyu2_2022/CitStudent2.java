package ensyu2_2022;

public class CitStudent2 {
	//生徒情報
	int no;
	int department;
	String name;
	int year;
	int grade;
	
	//小テスト
	private int high;
	private int low;
	private double avg;
	private int total;
	private int num;
	
	CitStudent2(){
		no = year = grade = department = 0;
		name = "";

		high = low = total = num = 0;
		avg = 0;
	}
	
	CitStudent2(int p_no, String p_name){
		//no = p_no;
		setNo(p_no);
		name = p_name;
		year = grade = 0;

		high = low = total = num = 0;
		avg = 0.0;
	}
	CitStudent2(int p_no, String p_name, int p_year){
		//no = p_no;
		setNo(p_no);
		name = p_name;
		year = p_year;
		grade = 0;
		
		high = low = total = num = 0;
		avg = 0;
	}
	
	//生徒
	public void setNo(int p_no) {
		no = p_no;
		department = (no / 1000) % 10;
	}
	public int getNo() {
		return no;
	}
	public int getDepartment() {
		return department;
	}
	public String getDepartmentName() {
		String departmentStr = "";
		if(department == 1)
			departmentStr = "情報工学科";
		else if(department == 2)
			departmentStr = "情報ネットワーク学科";
		
		return departmentStr;
	}
	public void setName(String p_name) {
		name = p_name;
	}
	public String getName() {
		return name;
	}
	public void setYear(int p_year) {
		year = p_year;
	}
	public int getYear() {
		return year;
	}
	public void setGrade(int p_grade) {
		grade = p_grade;
	}
	public int getGrade() {
		return grade;
	}
	public String getGradeName() {
		String gradeStr = "";
		if(getGrade() < 60)
			gradeStr = "D";
		else if(getGrade() < 70)
			gradeStr = "C";
		else if(getGrade() < 80)
			gradeStr = "B";
		else if(getGrade() < 90)
			gradeStr = "A";
		else
			gradeStr = "S";
		
		return gradeStr;
	}
	
	//小テスト
	public int getHigh() {
		return high;
	}
	public int getLow() {
		return low;
	}
	public double getAvg() {
		return avg;
	}
	public int getTotal() {
		return total;
	}
	public int getNum() {
		return num;
	}
	public void addScore(int score) {
		if(score < 0 || 100 < score) {
			System.out.println("addScore(int score): scoreは0<=score<=100でないといけません。");
			return;
		}
		if(num == 0) {
			high = score;
			low = score;
		}else {
			if(high < score)
				high = score;
			if(score < low)
				low = score;
		}
		num ++;
		total += score;
		avg = total / num;
	}
}
