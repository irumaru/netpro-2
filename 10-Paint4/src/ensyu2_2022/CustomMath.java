package ensyu2_2022;

//計算補助クラス
//Mathクラスの補助
public class CustomMath {
	//配列の中から最小値を求める
	public static int min(int count, int array[]) {
		int min = array[0];
		for(int i = 1; i < count; i ++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}
	
	//配列の中から最大値を求める
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
