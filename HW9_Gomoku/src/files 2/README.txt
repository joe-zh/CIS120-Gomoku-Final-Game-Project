=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: juezhou
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an approprate use of the concept. You may copy and paste from your proposal
  document if you did not change the features you are implementing.



Core Concept 1: 2D Array
What specific feature of your game will be implemented using this concept?

A 2D array intuitively represents the game board. It will contain the available spots that can be filled with pieces, black or white. It will allow me to search more easily than other data structures because we can run through the array and check if any 5 in a given direction are of the same color.

Why does it make sense to implement this feature with this concept? Justify why this is a non-trivial application of the concept in question.

The 2D array is an appropriate data structure because you cannot resize the screen, and it’s a regular grid with order and indices.


Core Concept 2: File I/O
What specific feature of your game will be implemented using this concept?

We will be keeping track of a set of Users that are playing the game, and during a game each user will keep track of the number of steps they have taken until the game ends. When the game ends, if the steps taken by the winning user is his/hers lowest so far, we will write this, along with the lowest number of steps taken by the loser, to a Score txt file, and when we wish to display the lowest steps, we will click a button and trigger the Filewriter to read from the file and display the lowest steps for both players. This list will be ordered, with whichever player has the lowest steps first.

Why does it make sense to implement this feature with this concept? Justify why this is a non-trivial application of the concept in question.

We want the high scores list to be an sorted ordered list of all-time lowest steps, which means that the number of steps need to be saved to a file in order to persist across sessions of the game, as soon as a lower step is available for a player. We will then read that file into our game when it launches or when someone wins. This is non-trivial because our popup that displays the steps will be ordered, with the user that has the least steps first. This can be done much more efficiently and logically with I/O. (If a user has step 0 this means he/she has not won yet, and so the exception in the game is that 0 is always considered “more steps” than other positive integers).


Core Concept 3: Complex search of game state
What specific feature of your game will be implemented using this concept?

After each player makes a move, we must iterate through the whole board to see if a player has won. This requires us to iterate through the entire chess board and check if there are 5 elements in the ‘piece’ array that are of the same color. We also need to check this in every direction.

Why does it make sense to implement this feature with this concept? Justify why this is a non-trivial application of the concept in question.

This is necessary because it is not a simple comparison between the stored values of the pieces. We must take into consideration of surrounding pieces to determine the win/lose state. I am expecting some cases such as when the pieces are at the end of the chess board, or when the the winning 5 pieces are diagonal. 


Core Concept 4: JUnit testingWhat specific feature of your game will be implemented using this concept?

We will test if we are implementing the game state checking correctly

Why does it make sense to implement this feature with this concept? Justify why this is a non-trivial application of the concept in question.

This makes sense to test over other components because this is the core of the game logic. We must make sure that in the module we exhaustively test every way that a player can win, and ensure that it is implemented correctly in the program. An example would be that a player should still win if he has more than 5 in a row (for example, have 4 in a row, and 1 piece one away, and the player places a piece in between those 5 pieces). As listed in MyTests, there are 13 total ways of winning in any direction, and on top of that there are multiple edge cases, making testing much more important for this game.



=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.

Game.java: This file contains a class with a simple main method. It contains code that prompts users to set their names, and then pops up the game window with a board, a status bar, restart button, show least step, and a “how-to” button

Piece.java: A class that creates a piece, either black or white. This is what each player puts down when it is their turn. A piece contains its x and y position and its color.

User.java: A class that creates a User, which keeps track of a name (string), and step(int). It implements comparable, and contains setters and getters for steps and names. The point of the User is to contain information of the 2 players in the game, to allow the players themselves to make up their own names, and to keep track of the number of steps taken during a game, as well as the least number of steps taken to win a round of game.

BoardPoint.java: A very simple class that stores an x and y of a pixel position, this is used to map the gameboard for efficiency because pieces must be placed on the intersection of lines. It is also used to adjust mouse clicks to a certain point such that the drawn pieces will be correctly aligned on the board.


MyTests.java: Contains all the JUnit tests for complex search of win/lost state.

Board.java: A JComponent on which the current game is displayed. It has a timer for every 35 milliseconds, which then utilizes a mouseMotionListener to draw an animated hover piece that follows the player’s mouse. It handles mouse clicks and adjusts them to the closest BoardPoint. It places a piece down in the corresponding color and position, if the position has not be taken by another piece. After every piece is placed it checks in different directions (horizontal, vertical, and diagonal) if any player has won, aka if anyone has had five pieces of the same color in a row (by using getPieceColor, isEmptySpot, and complex iterations). During the game it keeps track of how many steps each player has taken, and when a player wins it updates the score.txt if this is his least amount of steps taken the win thus far. It also contains methods to write and read scores/steps from a txt. It also contains a paintComponent that updates the steps, win/lose status, status bar display, grid display.



- Revisit your proposal document. What components of your plan did you end up
  keeping? What did you have to change? Why?

I ended up changing the aspect about file I/O. I ended up only making 2 users, not having the option to change user/usernames, and having the score window display least steps taken in a ordered fashion, instead of the win/lose scores of multiple users. I ended up changing this because I was running short of time, and I was unable to correctly read the scores in the right order to the txt once I play a game after changing a user. It was easier to implement a 2-user interface and have the system counting the least steps taken and order that.

Although not noted in the original proposal, I also changed the way I implemented the 2D array. Originally I had imagined of making a 2D array of JPanels. However later on I realized it was very difficult to make each square a JPanel and still have my piece be displayed on the intersections of the squares. I figured that it would be much easier to create a 2D array of set pixel points and write a set of code that can automatically adjust mouse clicks to a particular point that is closest to my click.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

It was fairly difficult to come up with the complex search algorithm. I found it tricky to count the number of consecutive and same-colored pieces, especially if a piece is close to an edge. Later on I realized that I could use functionalities analogous to clip() in the starter code, as well as methods to check if there is a piece there, and if so, what color is it.


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

I think for the most part my functionalities were reasonably efficient. The information that need to be encapsulated, such as user’s name, user’s steps, and many other private instance variables in Board.java were nicely protected. Other data structures such as the set of pieces and users that need to be accessed in other classes were also adjusted for those purposes. If I can improve upon my design, I would try to simplify my code more, as the methods to check Winning states in horizontal, vertical, lSlant, and rSlant directions are very similar in the way they check for win/lost states.



========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.

https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextPane.html




