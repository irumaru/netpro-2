package ensyu2_2022;

public class CircleTestMain {
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.move(100, 100);
		circle.print();
		circle.move(100, 100);
		circle.print();
		circle.moveto(100, 100);
		circle.print();
	}
}
