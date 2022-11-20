package ensyu2_2022;

public class SetGradeSample {
	public static void main(String[] args)
	{
		CitStudent2 koudai = new CitStudent2(2132043, "菊池 兼矢", 2);
		
		koudai.setGrade(60);
		
		showGrade(koudai);
	}
	public static void showGrade(CitStudent2 data)
	{	
		System.out.println("No: " + data.getNo() + " " + data.getDepartmentName() + " " + data.getName() + " " + data.getGradeName());
		System.out.println("High:" + data.getHigh() + " Avg:" + data.getAvg() + " Low:" + data.getLow() + " Total:" + data.getTotal());
		data.addScore(80);
		System.out.println("High:" + data.getHigh() + " Avg:" + data.getAvg() + " Low:" + data.getLow() + " Total:" + data.getTotal());
		data.addScore(60);
		System.out.println("High:" + data.getHigh() + " Avg:" + data.getAvg() + " Low:" + data.getLow() + " Total:" + data.getTotal());
		data.addScore(40);
		System.out.println("High:" + data.getHigh() + " Avg:" + data.getAvg() + " Low:" + data.getLow() + " Total:" + data.getTotal());
	}
}
