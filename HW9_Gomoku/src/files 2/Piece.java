/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.Color;
import java.awt.Graphics;

//A piece in the game board
public class Piece implements Comparable<Piece> {

	public int x; 
	public int y;
	public boolean color;

	public Piece(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;

	}
		
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setColor(boolean c) {
		this.color = c;
	}
	
	//draws a filled circle for the piece
	public void draw(Graphics g) {
		if (!color) {
			g.setColor(Color.black);
		}
		else {
			g.setColor(Color.white);
		}
		g.fillOval(x, y, 30, 30);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getColor() {
		return color;
		//false = black
		//true = white
	}
	

	public int compareTo(Piece a) {
		if (a.getX() == x && a.getY() == y && a.getColor() == color) {
			return 0;
		}
		return -1;
	}
	
}
