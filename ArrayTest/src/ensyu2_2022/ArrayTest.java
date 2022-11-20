package ensyu2_2022;

import java.util.ArrayList;

public class ArrayTest {
	ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) {
		//ArrayTest a = new ArrayTest();
	}
	
	ArrayTest(){
		this.list.add("Apple");
		this.list.add("Orange");
		this.list.add("Lemon");
		
		System.out.println(this.list.get(2));
	}
}
