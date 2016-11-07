/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.*;


/**	
 * Board
 * 
 * This class holds the primary game logic for how different objects interact
 * with one another. Take time to understand how the timer interacts with the
 * different methods and how it repaints the GUI on every tick().
 * 
 */
//15 by 15 grid

@SuppressWarnings("serial")
public class Board extends JPanel {
	private User user1;
	private User user2;	
	public static Set<User> users;	
	
	public boolean playing = false; // whether the game is running
	private JLabel status; // Current status text 
	private JLabel steps;
	BoardPoint[][] board = new BoardPoint [15][15];
	//coord of mouse after a click
	private int mouseX;
	private int mouseY;
	
	//variables needed for the animation when user hasn't clicked yet
	private int movingMouseX;
	private int movingMouseY;
	private static final Color HALF_BLACK = new Color (0, 0, 0, 125);
	private static final Color HALF_WHITE = new Color (255, 255, 255, 150);
	
	//variables needed when adjusting the clicked mouse position
	private int bestI;
	private int bestJ;	
	private boolean canPlace = true; //true if can place
	
	Set <Piece> pieces;		
	private boolean player = false;
	private boolean bWins = false;
	// Game constants
	public static final int COURT_WIDTH = 590;
	public static final int COURT_HEIGHT = 590;
	public static final int SQUARE_VELOCITY = 4;
	
	public static final int INTERVAL = 35;
	private int step1 = 0;
	private int step2 = 0;
	private int least1 = 1000000000;
	private int least2 = 1000000000;
	
	public Board(JLabel status, User user1, User user2, JLabel steps) {
		// creates border around the court area, JComponent method
		setBackground(Color.ORANGE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		this.user1 = user1;
		this.user2 = user2;
		users = new TreeSet<User>();
		users.add(this.user2);
		users.add(this.user1);
		writeScore(users);

		
		pieces = new TreeSet <Piece>();
		
		//2D array to make BoardPoints on the screen
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new BoardPoint(40* i + 15, 40 * j + 15);
			}
		}
		
		Timer timer = new Timer(INTERVAL, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();
		

		// Enable keyboard focus on the court area.
		setFocusable(true);

		// This key listener allows the square to move as long
		// as an arrow key is pressed, by changing the square's
		// velocity accordingly. (The tick method below actually
		// moves the square.)
	
		//mouse move listener for the hover piece 
		addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				if (playing) {
					movingMouseX = e.getX() - 19;
					movingMouseY = e.getY() - 19;
				}
			}		
		});
		
		//mouse click listener for all the piece placing action
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (playing) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						int minFinder = 100000000;
						mouseX = e.getX();
						mouseY = e.getY();
						//adjust to the closest BoardPoint coordinates
						for (int i = 0; i < board.length; i++) {
							for (int j = 0; j < board[0].length; j++) {
								int curr = (int) Math.sqrt((mouseX - 
										board[i][j].getX()) * 
										(mouseX - board[i][j].getX()) + 
										(mouseY - board[i][j].getY()) * 
										(mouseY - board[i][j].getY()));
								if (minFinder > curr) {
									minFinder = curr;
									bestI = i;
									bestJ = j;
								}								
							}
						}
						mouseX = board[bestI][bestJ].getX();
						mouseY = board[bestI][bestJ].getY();					

						//-15 to adjust to make sure the piece is on the grid
						
						//place the piece only if there are no pieces in it rn
						if (isEmptySpot(bestI, bestJ)) {
							pieces.add(new Piece (mouseX - 15, mouseY - 15, 
											player));
							if (!player) { //user1
								step1 = step1 + 1;
							}
							else {step2 = step2 + 1;}

								player = !player;
							checkWin(bestI, bestJ);
						}				
															
					}
					repaint();
			}
			
			}
			
		});

		this.status = status;
		this.steps = steps;
	}

	public void checkWin (int x, int y) {
		if (checkHWin(x, y)) {
			playing = false;
		}
		else if (checkVWin(x, y)) {
			playing = false;
		}
		else if (checkLSlantWin(x, y)) {
			playing = false;
		}
		else if (checkRSlantWin(x, y)) {
			playing = false;
		}
		else {
			playing = true;
		}
	}
	
	
	//check if there is another piece at that spot
	//returns false if there is a piece there rn
	public boolean isEmptySpot (int x, int y) {
		Iterator<Piece> iter = pieces.iterator();
		while (iter.hasNext()) {
			Piece current = iter.next();
			canPlace = current.getX() != (board[x][y].getX() - 15) || 
					current.getY() != (board[x][y].getY() - 15);
			if (!canPlace) {
				return canPlace;
			}
		}
		return canPlace;
	}
		
	//get color of the piece occupying a
	//particular element in the array
	public boolean getPieceColor(BoardPoint a) {
		Iterator<Piece> iter = pieces.iterator();
		while (iter.hasNext()) {
			Piece current = iter.next();
			if (current.getX() == 
					a.getX() - 15 &&
					current.getY() == 
					a.getY() - 15) {
				return current.getColor();
				//false is black
			}
		}
		throw new IllegalArgumentException("Impossible");
	}
	
	//check if someone has won in horizontal case, non-special
	public boolean checkHWin(int x, int y) {
		int [] hCase = new int [9];
		for (int i = 0; i < 9; i++) {
			//continue if this index is in the grid
			if (x - 4 + i >= 0 && x - 4 + i < board.length) {
				//if the spot has a piece in it
				if (!isEmptySpot(x - 4 + i, y)) {
					//2 is white, 1 is black
					if (getPieceColor(board[x - 4 + i][y])) {hCase[i] = 2;}
					else {hCase[i] = 1;}
				}
				else {hCase[i] = 0;}
			}
			else {hCase[i] = -1;}
		}
		return checkFivePieceWin(hCase);
	}
	
	//check if someone has won in vertical case
		public boolean checkVWin(int x, int y) {
			int [] vCase = new int [9];
			for (int i = 0; i < 9; i++) {
				//continue if point is in grid
				if (y - 4 + i >= 0 && y - 4 + i < board.length) {
					//if the spot is current not empty, then assign
					//2 to white and 1 to black
					if (!isEmptySpot(x, y - 4 + i)) {
						if (getPieceColor(board[x][y - 4 + i])) {vCase[i] = 2;}
						else {vCase[i] = 1;}
					}
					else {vCase[i] = 0;} //if the spot is empty then 0
				} else {vCase[i] = -1;} //if the spot is not in the grid
			}
			return checkFivePieceWin(vCase);
		}
	
		//check if someone has won in LSlant case
		public boolean checkLSlantWin(int x, int y) {
			int [] lCase = new int [9];
			for (int i = 0; i < 9; i++) {
				//continue if point is in grid
				if (y - 4 + i >= 0 && y - 4 + i < board.length &&
						x - 4 + i >= 0 && x - 4 + i < board.length) {
					if (!isEmptySpot(x - 4 + i, y - 4 + i)) {
						//2 is white, 1 is black
						if (getPieceColor(board[x - 4 + i][y - 4 + i])) {
							lCase[i] = 2;
						}
						else {lCase[i] = 1;}
					}
					else {lCase[i] = 0;}
				} else {lCase[i] = -1;}
			}
			return checkFivePieceWin(lCase);
		}
		
		//check if someone has won in RSlant case
		public boolean checkRSlantWin(int x, int y) {
			int [] rCase = new int [9];
			for (int i = 0; i < 9; i++) {
				//continue if point is in grid
				if (y + 4 - i >= 0 && y + 4 - i < board.length &&
					x - 4 + i >= 0 && x - 4 + i < board.length) {
					if (!isEmptySpot(x - 4 + i, y + 4 - i)) {
						//2 is white, 1 is black
						if (getPieceColor(board[x - 4 + i][y + 4 - i])) {
							rCase[i] = 2;
						}
						else {rCase[i] = 1;}
					}
					else {rCase[i] = 0;}
				} else {rCase[i] = -1;}
			}
			return checkFivePieceWin(rCase);
		}
		
	public boolean checkFivePieceWin(int[] c) {
		//loop for the number of ways the placed piece can be part of a
		//5 piece sequence. 1st piece -> last piece
		for (int j = 0; j < 5; j++) {
			//to loop through the 5 pieces and count Blacks&White
			int bCounter = 0;
			int wCounter = 0;
			for (int z = 0; z < 5; z++) {
				if (c[j + z] == 2) {wCounter++;}
				else if (c[j + z] == 1) {bCounter++;}	
			}
			if (bCounter >= 5) {
				bWins = true;
				user1.changeStep(step1); //update steps taken to win
				if (user1.getStep() < least1) { 
					//if steps are less than current least
					least1 = user1.getStep(); //update least counter
					writeScore(users); //update I/O only if steps have changed
				}
				return true;
			}
			if (wCounter >= 5) {
				bWins = false;
				user2.changeStep(step2);
				if (user2.getStep() < least2) {
					least2 = user2.getStep();
					writeScore(users); //if steps have changed then update
				}
				return true;
			}
		}			
		return false;
	}
	
	public String[] readScore() {
		FileReader r = null;
		BufferedReader bufferedR = null;
	    String[] orderedUsers = new String[2];
	    int i = 0;
		try {
			r = new FileReader("Score.txt");
			bufferedR = new BufferedReader(r);
			String line = bufferedR.readLine();
			while (line != null) {
				//only white spaces then go to next line
					 //comma cases
					int colonPos = line.indexOf(":");
					if (colonPos == -1) {
						throw new IllegalArgumentException ("No colon");
					}
					if (colonPos != line.lastIndexOf(":")) {
					  throw new IllegalArgumentException("more than one colon");
					}
					orderedUsers[i] = line;
					i = i+1;
					//so that it can repeat
					line = bufferedR.readLine();
			}
				return orderedUsers;			
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (bufferedR != null) {
					bufferedR.close();
				}
			} catch (IOException e) {
			    System.out.println("Wrong step.");
			}
		}
	}
		
	//writes score to txt file
	public static void writeScore (Set<User> users) {		
		File f = new File("Score.txt");
		if (!f.exists()) {
			try {
		     f.createNewFile();
		} catch (IOException e) {
		    System.out.println("Should not occur");
		    }
		}		   
		   FileWriter out = null;
		   BufferedWriter bufferedW = null;	
		try {
		    out = new FileWriter(f);
		    bufferedW = new BufferedWriter(out);
		    Iterator<User> iter = users.iterator();
		    User currBest = null;
		    //updating User removed allows us to 
		    //advice to the person with next lowest step
		    User removed = new User(":", 0);
		    //loop through it the number of users
			while (iter.hasNext()) {
				iter.next();
			    int bigStep = 1000000000;
		    	currBest = null;
			    for (User a: users) {
			    	//if the user is not the same as removed
			    	//and smaller than bigStep
			    	//because after the first loop, removed will be the lowest
			    	//step, we can only get to the next lowest user
			    	if(a.getStep() > 0 && a.getStep() < bigStep && 
			    			!a.equals(removed)) {
			    		bigStep = a.getStep();
			    		currBest = a;
			    	}
			    }
			    if (currBest != null) {
			    	bufferedW.write(currBest.getNickname() + ": " + 
			    				currBest.getStep() + "\r\n");
			    	removed = currBest; //set removed to the current lowest user
			    }
			}
			
			//list the user with 0 steps last
	    	for (User a: users) {
	    		if (a.getStep() == 0) {
			    	bufferedW.write(a.getNickname() + 
			    				": has not won " + "\r\n");
	    		}
	    	}
		    
		    
		   } catch (Exception e) {
		    //some errors
		   } finally {
		    if (bufferedW != null) {
		     try {
		      bufferedW.close();
		     } catch (IOException e) {
			  System.out.println("Should not occur");
		     }
		    }
		   }
	}
	
	
	
	/**
	 * (Re-)set the game to its initial state.
	 */
	public void reset() {
		player = false; //so black goes first again
		playing = true;
		bWins = false;
		step1 = 0;
		step2 = 0;
		status.setText("Black's Turn");
		steps.setText("     " + user1.getNickname() + ": 0 steps, " + 
				user2.getNickname() + ": 0 steps");
		canPlace = true;
		pieces.clear(); //remove all elements from the set of pieces
		//redraw board
		repaint();
		
		// Make sure that this component has the keyboard focus
		requestFocusInWindow();
	}


	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//2D array to connect the grid
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board[0].length - 1; j++) {
				int x1 = board[i][j].getX();
				int y1 = board[i][j].getY();
				
				g.drawRect(x1, y1, 40, 40);
			}
		}
		//dots for aesthetics, part of the grid
		g.fillOval(board[3][3].getX() - 3, board[3][3].getY() - 3, 6, 6);
		g.fillOval(board[7][7].getX() - 5, board[7][7].getY() - 5, 10, 10);
		g.fillOval(board[3][11].getX() - 3, board[3][11].getY() - 3, 6, 6);
		g.fillOval(board[11][3].getX() - 3, board[11][3].getY() - 3, 6, 6);
		g.fillOval(board[11][11].getX() - 3, board[11][11].getY() - 3, 6, 6);
		
		//drawing the hovering piece based on next player move
		if (!player && playing) {
			g.setColor(HALF_BLACK);
			g.fillOval(movingMouseX, movingMouseY, 40, 40);//draw black one
		}
		if (player && playing){
			g.setColor(HALF_WHITE);
			g.fillOval(movingMouseX, movingMouseY, 40, 40);
		}
		
		
		Iterator<Piece> iter = pieces.iterator();
		while (iter.hasNext()) {			
			Piece current = iter.next();
			current.draw(g);
		}
		
		if (playing) {
			steps.setText("     " + user1.getNickname() + ": " + step1 + 
					" steps, " + user2.getNickname() + ": " + step2 + " steps");
		}
		if (player && playing) {
			status.setText(user2.getNickname() + "'s turn");
		}
		else if (!player && playing) {
			status.setText(user1.getNickname() + "'s turn");
		}
		else if (!playing && bWins) {
			status.setText(user1.getNickname() + " Has Won");
		}
		else if (!playing && !bWins) {
			status.setText(user2.getNickname() + " Has Won");
		}

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COURT_WIDTH, COURT_HEIGHT);
	}
	
	
}
