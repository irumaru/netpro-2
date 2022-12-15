//オブジェクトの基準点
package ensyu2_2022;

import java.io.Serializable;
import java.util.ArrayList;

//Coordクラスの宣言
//図形の基準点に関することを記述
//Serializableをimprementsすることで、Coordを継承するクラスのインスタンスも含め、ファイルなどへ出力することをできるようにする
public class Coord implements Serializable{
	//基準点を宣言
	int x, y;
	//n点指定図形の2点目以降の1点目との差分を格納するインスタンス
	ArrayList<Integer> coordXList = new ArrayList<Integer>();
	ArrayList<Integer> coordYList = new ArrayList<Integer>();
	//描画中のn点指定図形のマウスを追尾する線の基準点を格納
	//nullで非図形描画中
	Integer forcusX, forcusY;
	//coordXListなどをint型を変換したときの配列の長さ
	Integer count;
	
	//基準点プロパティを0で初期化
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
	
	//n点指定図形の2点目以降をリストの後尾へ追加
	//引数は絶対座標
	public void addCoord(Integer x, Integer y) {
		//1点目との差を計算して相対座標として格納
		coordXList.add(x - this.x);
		coordYList.add(y - this.y);
	}
	
	//描画中のn点指定図形のマウスを追尾する線の基準点を設定
	//引数は絶対座標
	public void addVirtualCoord(int x, int y) {
		forcusX = x;
		forcusY = y;
	}
	
	//n点指定図形の描画する点の集合をint型配列として取得
	//アクセス修飾子がprivateのため、このインスタンスのみから参照可
	private int[] getCoordArray(ArrayList<Integer> coords, Integer forcus, Integer xy) {
		//coordsの長さ+基準点+図形作成中の点 分の長さのInt型配列を作成
		int[] coordArray = new int[coords.size() + 2];
		
		//0番目にmovetoで指定した基準点を代入
		coordArray[0] = xy;
		//次にcoordArrayを追加
		for(int i = 0; i < coords.size(); i ++) {
			//coordsは相対座標なので、絶対座標へ変換
			coordArray[i + 1] = coords.get(i) + xy;
		}
		
		//coordArrayの有効な(数値が入っている)長さ
		count = coords.size() + 1;
		
		//図形が作成中の場合
		if(forcus != null) {
			//マウスを追尾する点を末尾に追加
			coordArray[coords.size() + 1] = forcus;
			//カウントアップ
			count ++;
			//仮の点は1度のみ表示
			//ダブルクリックの2回目の点を無効化(2回目に座標がずれて、おかしな線が追加されるのを防ぐ)
			forcus = null;
		}
		
		return coordArray;
	}
	
	//n点指定図形描画用、点の集合(Int型配列)を取得
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