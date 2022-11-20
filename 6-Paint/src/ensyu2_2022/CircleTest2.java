package ensyu2_2022;

import java.util.ArrayList;

public class CircleTest2 {
	public static void main(String[] args) {
		ArrayList<Coord> objList = new ArrayList<Coord>();//図形管理
		
		Coord c = new Circle();//Coordクラスの変数にCircleを代入
		
		objList.add(c);
		c.move(100, 100);
		System.out.println("x = " + c.x + " y = " + c.y);
		//c.setSize(20);
		
		Coord d = objList.get(0);
		System.out.println("x = " + d.x + " y = " + d.y);
	}
}
