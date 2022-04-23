# csc116-007-CE-03

## Connect Four!

Names: Om Pandey, Bowen Deng, Anthony Du, Shuhao Liu

## Link to Documentation

https://docs.google.com/document/d/1mqo0MzBDYSwh6hT8MeZT_uHNKbhttq9HUUyUDQ-_Dd8/edit?usp=sharing

## How to Play

This is a two player game that could be run in a Unix shell with the command ```java -cp bin ConnectFourUI``` once you've compiled the Java source code into the bin folder using ```javac -d bin -cp bin src/*```. The program will first ask the user for a win condition (connection length). This number will also determine the size of the grid (which would be a square with a side length double the connection length). The users then take turns to drop in their pieces into the grid by typing in a column number. The piece would fall down to the lowest available space as a normal connect four game would. Empty spaces are represented by ```-``` symbols on the grid. The piece of whoever goes first is represented by ```X``` symbols on the grid, and the piece of the other player is represented by an ```O``` symbol on the grid. This keeps going until one of the players connects more than the minimum connection length to win. The statistics of each player will be shown on the right side of the grid to allow the players to easily keep track of the state of the game. After each game, the players can choose to either play again or to quit by pressing ```q``` at any point during the game. We hope you enjoy our game!

```
% java -cp bin ConnectFourUI           

Welcome to Connect Four!
(enter "q" to exit game)

Please type in the required connection length to win: 4

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         0
	-  -  -  -  -  -  -  -  		Max connection length: 1
	-  -  -  -  -  -  -  -  	Player 2 (O):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         0
	-  -  -  -  -  -  -  -  		Max connection length: 1

Player 1, enter the column you want to drop your next chip in: 1

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         1
	-  -  -  -  -  -  -  -  		Max connection length: 1
	-  -  -  -  -  -  -  -  	Player 2 (O):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         0
	X  -  -  -  -  -  -  -  		Max connection length: 1

Player 2, enter the column you want to drop your next chip in: 2

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         1
	-  -  -  -  -  -  -  -  		Max connection length: 1
	-  -  -  -  -  -  -  -  	Player 2 (O):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         1
	X  O  -  -  -  -  -  -  		Max connection length: 1

Player 1, enter the column you want to drop your next chip in: 1

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         2
	-  -  -  -  -  -  -  -  		Max connection length: 2
	-  -  -  -  -  -  -  -  	Player 2 (O):
	-  -  -  -  -  -  -  -  		Games won:             0
	X  -  -  -  -  -  -  -  		Pieces placed:         1
	X  O  -  -  -  -  -  -  		Max connection length: 1

Player 2, enter the column you want to drop your next chip in: 2

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         2
	-  -  -  -  -  -  -  -  		Max connection length: 2
	-  -  -  -  -  -  -  -  	Player 2 (O):
	-  -  -  -  -  -  -  -  		Games won:             0
	X  O  -  -  -  -  -  -  		Pieces placed:         2
	X  O  -  -  -  -  -  -  		Max connection length: 2

Player 1, enter the column you want to drop your next chip in: 1

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         3
	-  -  -  -  -  -  -  -  		Max connection length: 3
	-  -  -  -  -  -  -  -  	Player 2 (O):
	X  -  -  -  -  -  -  -  		Games won:             0
	X  O  -  -  -  -  -  -  		Pieces placed:         2
	X  O  -  -  -  -  -  -  		Max connection length: 2

Player 2, enter the column you want to drop your next chip in: 2

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         3
	-  -  -  -  -  -  -  -  		Max connection length: 3
	-  -  -  -  -  -  -  -  	Player 2 (O):
	X  O  -  -  -  -  -  -  		Games won:             0
	X  O  -  -  -  -  -  -  		Pieces placed:         3
	X  O  -  -  -  -  -  -  		Max connection length: 3

Player 1, enter the column you want to drop your next chip in: 1

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         4
	-  -  -  -  -  -  -  -  		Max connection length: 4
	X  -  -  -  -  -  -  -  	Player 2 (O):
	X  O  -  -  -  -  -  -  		Games won:             0
	X  O  -  -  -  -  -  -  		Pieces placed:         3
	X  O  -  -  -  -  -  -  		Max connection length: 3

Player 1, you are the winner!

A new game has started.

	1  2  3  4  5  6  7  8  
	-  -  -  -  -  -  -  -  	Player 1 (X):
	-  -  -  -  -  -  -  -  		Games won:             1
	-  -  -  -  -  -  -  -  		Pieces placed:         0
	-  -  -  -  -  -  -  -  		Max connection length: 1
	-  -  -  -  -  -  -  -  	Player 2 (O):
	-  -  -  -  -  -  -  -  		Games won:             0
	-  -  -  -  -  -  -  -  		Pieces placed:         0
	-  -  -  -  -  -  -  -  		Max connection length: 1

Player 1, enter the column you want to drop your next chip in: q
```
