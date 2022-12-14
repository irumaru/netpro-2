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
	
	public void addCoord(Integer x, Integer y) {
		coordXList.add(x - this.x);
		coordYList.add(y - this.y);
	}
	
	public void addVirtualCoord(int x, int y) {
		forcusX = x;
		forcusY = y;
	}
	
	private int[] getCoordArray(ArrayList<Integer> coords, Integer forcus, Integer xy) {
		int[] coordArray = new int[coords.size() + 2];
		
		//0番目にmovetoで指定した基準点を代入
		coordArray[0] = xy;
		//次にcoordArrayを追加
		for(int i = 0; i < coords.size(); i ++) {
			coordArray[i + 1] = coords.get(i) + xy;
		}
		
		count = coords.size() + 1;
		
		if(forcus != null) {
			//仮の点を末尾に追加
			coordArray[coords.size() + 1] = forcus;
			//仮の点のカウントを追加
			count ++;
			//仮の点は1度のみ表示
			//ダブルクリックの2回目の点を無効化
			forcus = null;
		}
		
		return coordArray;
	}
	
	protected int[] getCoordXArray() {
		int[] array = getCoordArray(coordXList, forcusX, x);
		forcusX = null;
		return array;
	}
	
	protected int[] getCoordYArray() {
		int[] array = getCoordArray(coordYList, forcusY, y);
		forcusY = null;
		return array;
	}
}