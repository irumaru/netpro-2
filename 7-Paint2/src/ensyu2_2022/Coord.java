//オブジェクトの基準点

package ensyu2_2022;

//Coordクラスの宣言
//図形の基準点に関することを記述
public class Coord {
	//x,yプロパティを宣言
	int x, y;
	
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
}