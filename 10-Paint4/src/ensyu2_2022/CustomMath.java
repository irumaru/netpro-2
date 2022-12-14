package ensyu2_2022;

public class CustomMath {
	public static int min(int count, int array[]) {
		int min = array[0];
		for(int i = 1; i < count; i ++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}
	
	public static int max(int count, int array[]) {
		int max = array[0];
		for(int i = 1; i < count; i ++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		
		return max;
	}
}
