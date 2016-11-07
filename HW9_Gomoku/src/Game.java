/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
//The GUI is laid out using GridBagLayout
//there exists a constraint c that tells each panel to do something
public class Game implements Runnable {
	private Board board;
	public User user1;
	public User user2;	
	
	public void run() {		
		String username1 = ":";
		String username2 = ":";
			//setting up name for user1
		while (username1.indexOf(":") != -1) {
			username1 = JOptionPane.showInputDialog("Please enter "
					+ "name for User 1:");
			//if it doens't contain , then continue b/c , is illegal
			if (username1.indexOf(":") != -1) {
				JOptionPane.showMessageDialog(null, "Your Name "
						+ "Cannot Contain a Colon ", "ERROR", 
						JOptionPane.ERROR_MESSAGE);
			}
		}		
			user1 = new User(username1, 0);
			//setting up name for user2
		while (username2.indexOf(":") != -1) {
			username2 = JOptionPane.showInputDialog("Please enter "
					+ "name for User 2:");
			//if it doens't contain , then continue b/c , is illegal
			if (username2.indexOf(":") != -1) {
				JOptionPane.showMessageDialog(null, "Your Name "
					+ "Cannot Contain a Colon ", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
			}
		}
		user2 = new User(username2, 0);
	
				// Top-level frame in which game components live
				final JFrame frame = new JFrame("Gomoku");
				frame.setLocation(500, 500);		
				frame.setLayout(new GridBagLayout());
				GridBagConstraints c = new GridBagConstraints();
				
				//JPanel that contains a JLabel, tells who's turn and if
				//someone has won
				final JPanel status_panel = new JPanel();
				c.fill = GridBagConstraints.HORIZONTAL;
				c.ipady = 0; 
				c.weighty = 1.0;  
				c.gridx = 0;
				c.gridwidth = 1;   
				c.gridy = 0;     
				frame.add(status_panel, c);
				final JLabel status = new JLabel("Start Game");
				status_panel.add(status);
			
				
				final JLabel steps = new JLabel("Steps");
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = 1;
				c.gridy = 0;
				c.gridheight = 1;
				c.gridwidth = 2;
				frame.add(steps, c);	
				
				// Main playing area
				board = new Board(status, user1, user2, steps);
				c.fill = GridBagConstraints.VERTICAL;
				c.gridheight = 1;
				c.gridwidth = 1; //
				c.gridx = 0;
				c.gridy = 1;
				frame.add(board, c);				
				
				//reset button
				final JButton reset = new JButton("Restart");
				reset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						board.reset();
					}
				});
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0;
				c.gridx = 0;
				c.gridy = 2;
				frame.add(reset, c);	
				
				//New JFrame for instruction window
				final JFrame instruction_window = new JFrame("How-To Gomoku");
				instruction_window.setSize(300, 300);
				JTextPane words = new JTextPane();	
				words.setText("Gomoku is to be played by two players, "
						+ "whose names are determined as you enter the game. "
						+ "One player will be using the black pieces and "
						+ "the other  \r\n"
						+ "using the white pieces. The players will "
						+ "alternate turns "
						+ "and place pieces on any non-occupied "
						+ "intersection  \r\n point "
						+ "on the grid. Black goes first. A Player "
						+ "wins when he/she"
						+ "has five or more pieces in a row  \r\n "
						+ "(horizontally, vertically,"
						+ "or diagonally). The goal of the game is "
						+ "to prevent the other"
						+ "player from making five pieces in a row, "
						+ " \r\n and at the same "
						+ "time try to put down five consecutive pieces first."
						+ " \r\n"
						+ "With each mouse click, the program will "
						+ "automatically "
						+ "detect the closest available spot to place a "
						+ "piece and put "
						+ "the piece there.  \r\nIf there are no available "
						+ "spots, the click "
						+ "will not conduct any actions and the user must "
						+ "move the mouse "
						+ "to an available location and place the piece."
						+ " \r\n"
						+ "As the player moves the piece around while "
						+ "deciding his "
						+ "move, there will be a semi-transparent  \r\n "
						+ "hover piece that "
						+ "follows the mouse. The piece will have "
						+ "corresponding color "
						+ "as the player."
						+ " \r\n"
						+ "Once a player wins, no more pieces can "
						+ "be placed down, and"
						+ " the winner will be announced  \r\nat the "
						+ "top of the page."
						+ " \r\n"
						+ "As you play, there will be a counter on the top "
						+ "right side that keeps track of each player's number "
						+ "of steps taken. \r\n If you win with a lower number "
						+ "of steps than all of your previous wins, your score "
						+ "will update and you can check that at the button "
						+ "located on the top right hand side. \r\n If you "
						+ "have not won, the score window will show "
						+ "accordingly. If you restart the game, your steps "
						+ "will reset, but your lowest number of steps will "
						+ "not. \r\n"
						+ "When you restart the game, the board will be "
						+ "cleared and black will go first again. \r\n"
						+ "The score table will be displayed in an ordered "
						+ "fashion, with the lowest positive steps at the top."
						+ "\r\n"
						+ "Have fun!");
				instruction_window.add(words);
				
				final JButton instructions = new JButton("How-To");
				instructions.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						instruction_window.pack();
						instruction_window.setDefaultCloseOperation
						(JFrame.HIDE_ON_CLOSE);
						instruction_window.setVisible(true);			
					}
				});
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0;
				c.gridx = 1;
				c.gridy = 2;
				frame.add(instructions, c);
				
				
						
				
			
				
				//JPanel that contains a table of the top 10 scores users, listed
				//in order
				final JPanel high_score = new JPanel();
				c.fill = GridBagConstraints.BOTH;
				c.gridx = 1;
				c.gridy = 1;
				c.gridheight = 1;
				c.gridwidth = 2;
				frame.add(high_score, c);
				
								
				final JButton scores = new JButton("Least Number of Steps to Win");
				scores.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Popup frame that displays the highscores
						final JFrame highscore_window = new JFrame("Steps");
						highscore_window.setLocation(300, 300);
						JTextPane highscoreText = new JTextPane();
						
						String totalWords = "";
						//read the text file
						String[] userArr = board.readScore();
						for (int i = 0; i < userArr.length; i++) {
							totalWords = totalWords + userArr[i] + "\r\n";

						}			
						
						highscoreText.setText(totalWords);
						highscore_window.add(highscoreText);
						highscore_window.pack();
						highscore_window.setDefaultCloseOperation
						(JFrame.HIDE_ON_CLOSE);
						highscore_window.setVisible(true);
					}
				});
				high_score.add(scores);
			


				// Put the frame on the screen
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

				// Start game
				board.reset();
			}
		


		
		
	

	/*
	 * Main method run to start and run the game Initializes the GUI elements
	 * specified in Game and runs it IMPORTANT: Do NOT delete! You MUST include
	 * this in the final submission of your game.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}
}
