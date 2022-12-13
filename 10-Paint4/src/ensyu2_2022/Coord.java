//オブジェクトの基準点

package ensyu2_2022;

import java.io.Serializable;
import java.util.ArrayList;

//Coordクラスの宣言
//図形の基準点に関することを記述
public class Coord implements Serializable{
	//x,yプロパティを宣言
	int x, y;
	ArrayList<Integer> coordXList = new ArrayList<Integer>();
	ArrayList<Integer> coordYList = new ArrayList<Integer>();
	Integer forcusX, forcusY, count;
	
	//x,yプロパティを0で初期化
	Coord(){
		x = y = 0;
	}
	
	//図形の基準点をずらす(今回は未使用)
	public void move(int dx, int dy){
		x += dx;
		y += dy;
	}
	
	//図形の基準点を設定
	public void moveto(int x, int y){
		//xはメソッド内の変数、this.xはプロパティ
		this.x = x;
		this.y = y;
	}
	
	public void setXY(Integer x, Integer y) {
		coordXList.add(x);
		coordYList.add(y);
	}
	
	public void forcusXY(int x, int y) {
		forcusX = x;
		forcusY = y;
	}
	
	private int[] getIntArray(ArrayList<Integer> coords, Integer forcus, Integer point) {
		int[] coordsInt = new int[coords.size() + 2];
		
		coordsInt[0] = point;
		System.out.println(point);
		for(int i = 0; i < coords.size(); i ++) {
			coordsInt[i + 1] = coords.get(i);
		}
		
		count = coords.size() + 1;
		
		if(forcus != null) {
			coordsInt[coords.size() + 1] = forcus;
			count ++;//forcus分のカウントを追加
			
			//仮の点は1度のみ表示
			//ダブルクリックの2回目の点を無効化
			forcus = null;
		}
		
		return coordsInt;
	}
	
	protected int[] getCoordXs() {
		int[] array = getIntArray(coordXList, forcusX, x);
		forcusX = null;
		return array;
	}
	
	protected int[] getCoordYs() {
		int[] array = getIntArray(coordYList, forcusY, y);
		forcusY = null;
		return array;
	}
}