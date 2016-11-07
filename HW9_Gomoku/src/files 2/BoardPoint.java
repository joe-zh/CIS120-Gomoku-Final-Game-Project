//A point on the gameboard
//we can use a 2D array of BoardPoints to draw the board and help placing
//pieces down
public class BoardPoint {
	public int x;
	public int y;
	
	public BoardPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
