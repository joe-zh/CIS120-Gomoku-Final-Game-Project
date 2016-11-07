import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JLabel;

import org.junit.*;

//Testing the Complex Search Algorithm and different possibilities
//and edge cases
	/*
	Total ways to win, x is placed pieces, o is last placed piece
	oxxxx
	xxxxo
	xxxox
	xoxxx
	xxoxx
	xxxxox
	xoxxxx
	xxxoxxx
	xxxxoxx
	xxoxxxx
	xxxxoxxx
	xxxoxxxx
	xxxxoxxxx
	*/
	/*
	Total areas of winning, as well as total number of edge cases
	Middle
	Top Left
	Middle Top
	Top Right
	Mid Left
	Mid Right
	Bottom Left
	Bottom Mid
	Bottom Right
	*/
public class MyTests {
	private User user1 = new User("Joe", 0);
	private User user2 = new User("120", 0);
	Board b = new Board(null, user1, user2, null);
	
	private int mouseX;
	private int mouseY;
	
	@Test
	public void HorizontalMiddle() {
		int i = 4;
		int j = 7;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalMiddle() {
			int i = 7;
			int j = 4;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantMiddle() {
			int i = 4;
			int j = 4;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantMiddle() {
			int i = 4;
			int j = 12;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	
	@Test
	public void HorizontalTopLeft() {
		int i = 0;
		int j = 0;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalTopLeft() {
			int i = 0;
			int j = 0;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantTopLeft() {
			int i = 0;
			int j = 0;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantTopLeft() {
			int i = 0;
			int j = 8;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	
	@Test
	public void HorizontalMidTop() {
		int i = 4;
		int j = 0;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalMidTop() {
			int i = 7;
			int j = 0;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantMidTop() {
			int i = 4;
			int j = 0;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantMidTop() {
			int i = 4;
			int j = 8;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	
	@Test
	public void HorizontalTopRight() {
		int i = 6;
		int j = 0;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalTopRight() {
			int i = 14;
			int j = 0;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantTopRight() {
			int i = 6;
			int j = 0;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantTopRight() {
			int i = 6;
			int j = 8;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	
	@Test
	public void HorizontalMidLeft() {
		int i = 0;
		int j = 7;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalMidLeft() {
			int i = 0;
			int j = 4;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantMidLeft() {
			int i = 0;
			int j = 4;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantMidLeft() {
			int i = 0;
			int j = 12;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	
	@Test
	public void HorizontalMidRight() {
		int i = 6;
		int j = 7;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalMidRight() {
			int i = 14;
			int j = 4;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantMidRight() {
			int i = 6;
			int j = 4;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantMidRight() {
			int i = 6;
			int j = 12;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	
	@Test
	public void HorizontalBottomLeft() {
		int i = 0;
		int j = 14;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalBottomLeft() {
			int i = 0;
			int j = 6;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantBottomLeft() {
			int i = 0;
			int j = 6;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantBottomLeft() {
			int i = 0;
			int j = 14;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}
	
	
	@Test
	public void HorizontalBottomMid() {
		int i = 4;
		int j = 14;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalBottomMid() {
			int i = 7;
			int j = 6;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantBottomMid() {
			int i = 4;
			int j = 6;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantBottomMid() {
			int i = 4;
			int j = 14;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}	
	
	
	@Test
	public void HorizontalBottomRight() {
		int i = 6;
		int j = 14;
		//putting down x before xxxx
		mouseX = b.board[i + 1][j].getX();
		mouseY = b.board[i + 1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 1,j);
		assertTrue("x before xxxx 1", b.playing == true);
		mouseX = b.board[i + 2][j].getX();
		mouseY = b.board[i + 2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 2,j);
		assertTrue("x before xxxx 2", b.playing == true);
		mouseX = b.board[i + 3][j].getX();
		mouseY = b.board[i + 3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i + 3,j);
		assertTrue("x before xxxx 3", b.playing == true);
		mouseX = b.board[i + 4][j].getX();
		mouseY = b.board[i + 4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i + 4,j);
		assertTrue("x before xxxx 4", b.playing == true);	
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x before xxxx 5", b.playing == false);
		b.pieces.clear();	
		
		//xxxxo
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxx x and then fill blank
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxx x and then fill blank 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxx x and then fill blank 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxx x and then fill blank 3", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxx x and then fill blank 4", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxx x and then fill blank 5", b.playing == false);
		b.pieces.clear();
		
		//x xxx then fill
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("x xxx then fill 1", b.playing == true);

		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("x xxx then fill 2", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("x xxx then fill 3", b.playing == true);		
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("x xxx then fill 4", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("x xxx then fill 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxox
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);	
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == false);		
		b.pieces.clear();
		//xxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == true);			
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);	
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == false);
		b.pieces.clear();
		//xxxxoxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		
		//xxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxoxx 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxoxx 2", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxoxx 4", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxoxx 5", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+5,j);
		assertTrue("xxoxx 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+6,j);
		assertTrue("xxoxx 7", b.playing == true);		
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxoxx 3", b.playing == false);
		b.pieces.clear();
		
		//xxxxoxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);		
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);		
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);		
		assertTrue("xxxxo 8", b.playing == true);		
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
		//xxxxoxxxx
		mouseX = b.board[i][j].getX();
		mouseY = b.board[i][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i,j);
		assertTrue("xxxxo 1", b.playing == true);
		mouseX = b.board[i+1][j].getX();
		mouseY = b.board[i+1][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+1,j);
		assertTrue("xxxxo 2", b.playing == true);
		mouseX = b.board[i+2][j].getX();
		mouseY = b.board[i+2][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+2,j);
		assertTrue("xxxxo 3", b.playing == true);
		mouseX = b.board[i+3][j].getX();
		mouseY = b.board[i+3][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+3,j);
		assertTrue("xxxxo 4", b.playing == true);
		mouseX = b.board[i+5][j].getX();
		mouseY = b.board[i+5][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+5,j);
		assertTrue("xxxxo 6", b.playing == true);
		mouseX = b.board[i+6][j].getX();
		mouseY = b.board[i+6][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+6,j);
		assertTrue("xxxxo 7", b.playing == true);
		mouseX = b.board[i+7][j].getX();
		mouseY = b.board[i+7][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+7,j);
		assertTrue("xxxxo 8", b.playing == true);
		mouseX = b.board[i+8][j].getX();
		mouseY = b.board[i+8][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));		
		b.checkWin(i+8,j);
		assertTrue("xxxxo 9", b.playing == true);
		mouseX = b.board[i+4][j].getX();
		mouseY = b.board[i+4][j].getY();
		b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
				false));
		b.checkWin(i+4,j);
		assertTrue("xxxxo 5", b.playing == false);		
		b.pieces.clear();
	}
	
	@Test
	public void VerticalBottomRight() {
			int i = 14;
			int j = 6;
			//putting down x before xxxx
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i][j+1].getX();
			mouseY = b.board[i][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i][j+2].getX();
			mouseY = b.board[i][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i][j+3].getX();
			mouseY = b.board[i][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i][j+5].getX();
			mouseY = b.board[i][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i][j+6].getX();
			mouseY = b.board[i][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i][j+7].getX();
			mouseY = b.board[i][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i][j+8].getX();
			mouseY = b.board[i][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i][j+4].getX();
			mouseY = b.board[i][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void LSlantBottomRight() {
			int i = 6;
			int j = 6;
			//putting down x before xxxx
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j+5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j+6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j+1].getX();
			mouseY = b.board[i+1][j+1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j+1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j+2].getX();
			mouseY = b.board[i+2][j+2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j+2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j+3].getX();
			mouseY = b.board[i+3][j+3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j+3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j+5].getX();
			mouseY = b.board[i+5][j+5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j+5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j+6].getX();
			mouseY = b.board[i+6][j+6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j+6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j+7].getX();
			mouseY = b.board[i+7][j+7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j+7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j+8].getX();
			mouseY = b.board[i+8][j+8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j+8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j+4].getX();
			mouseY = b.board[i+4][j+4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j+4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}

	@Test
	public void RSlantBottomRight() {
			int i = 6;
			int j = 14;
			//putting down x before xxxx
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x before xxxx 1", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x before xxxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x before xxxx 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x before xxxx 4", b.playing == true);	
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x before xxxx 5", b.playing == false);
			b.pieces.clear();	
			
			//xxxxo
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxx x and then fill blank
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxx x and then fill blank 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxx x and then fill blank 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxx x and then fill blank 3", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxx x and then fill blank 4", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxx x and then fill blank 5", b.playing == false);
			b.pieces.clear();
			
			//x xxx then fill
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("x xxx then fill 1", b.playing == true);

			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("x xxx then fill 2", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("x xxx then fill 3", b.playing == true);		
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("x xxx then fill 4", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("x xxx then fill 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxox
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);	
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == false);		
			b.pieces.clear();
			//xxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == true);			
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);	
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == false);
			b.pieces.clear();
			//xxxxoxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			
			//xxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxoxx 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxoxx 2", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxoxx 4", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxoxx 5", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+5,j-5);
			assertTrue("xxoxx 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+6,j-6);
			assertTrue("xxoxx 7", b.playing == true);		
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxoxx 3", b.playing == false);
			b.pieces.clear();
			
			//xxxxoxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);		
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);		
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);		
			assertTrue("xxxxo 8", b.playing == true);		
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
			//xxxxoxxxx
			mouseX = b.board[i][j].getX();
			mouseY = b.board[i][j].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i,j);
			assertTrue("xxxxo 1", b.playing == true);
			mouseX = b.board[i+1][j-1].getX();
			mouseY = b.board[i+1][j-1].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+1,j-1);
			assertTrue("xxxxo 2", b.playing == true);
			mouseX = b.board[i+2][j-2].getX();
			mouseY = b.board[i+2][j-2].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+2,j-2);
			assertTrue("xxxxo 3", b.playing == true);
			mouseX = b.board[i+3][j-3].getX();
			mouseY = b.board[i+3][j-3].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+3,j-3);
			assertTrue("xxxxo 4", b.playing == true);
			mouseX = b.board[i+5][j-5].getX();
			mouseY = b.board[i+5][j-5].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+5,j-5);
			assertTrue("xxxxo 6", b.playing == true);
			mouseX = b.board[i+6][j-6].getX();
			mouseY = b.board[i+6][j-6].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+6,j-6);
			assertTrue("xxxxo 7", b.playing == true);
			mouseX = b.board[i+7][j-7].getX();
			mouseY = b.board[i+7][j-7].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+7,j-7);
			assertTrue("xxxxo 8", b.playing == true);
			mouseX = b.board[i+8][j-8].getX();
			mouseY = b.board[i+8][j-8].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));		
			b.checkWin(i+8,j-8);
			assertTrue("xxxxo 9", b.playing == true);
			mouseX = b.board[i+4][j-4].getX();
			mouseY = b.board[i+4][j-4].getY();
			b.pieces.add(new Piece (mouseX - 15, mouseY - 15, 
					false));
			b.checkWin(i+4,j-4);
			assertTrue("xxxxo 5", b.playing == false);		
			b.pieces.clear();
		}	
}
