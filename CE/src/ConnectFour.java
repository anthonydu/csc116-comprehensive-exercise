/**
 * The Connect Four Game
 * @author Anthony Du
 * @author Bowen Deng
 * @author Om Pandey
 * @author Shuhao Liu
 */
public class ConnectFour {

    /** The number of rows and columns of the game board */
    private int gridSize;

    /** The smallest maximum connection needed to win the game */
    private int connectTarget;

    /** Determines whose turn (of the 2 players) is it */
    private int playerState;

    /** The first player */
    private Player player1;

    /** The second player */
    private Player player2;

    /** THe ConnectFour game grid */
    private char[][] grid;

    /**
     * Constructs a new ConnectFour to initialize all spots on the board to "-"
     * Assigns connectTarget, player1, and player2 to their instance fields
     * Initializes playerState to 1 to make it the first player's turn
     *
     * @param connectTarget the smallest maximum connection
     * needed to win the game
     * @param player1 the first player
     * @param player2 the second player
     */
    public ConnectFour(int connectTarget, Player player1, Player player2) {
        this.connectTarget = connectTarget;
        this.gridSize = connectTarget * 2;
        this.player1 = player1;
        this.player2 = player2;

        grid = new char[gridSize][gridSize];
        for (int i = gridSize - 1; i >= 0; i--) {
            for (int j = gridSize - 1; j >= 0; j--) {
                grid[i][j] = '-';
            }
        }
        playerState = 1;
    }

    /**
     * Returns the state number that indicates whose turn it is
     * @return the state number that indicates whose turn it is
     */
    public int getPlayerState() {
        return playerState;
    }

    /**
     * Returns the first player
     * @return the first player
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Returns the second player
     * @return the second player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Returns the number of rows and columns of the game board
     * @return the number of rows and columns of the game board
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * Returns the smallest maximum connection needed to win the game
     * @return the smallest maximum connection needed to win the game
     */
    public int getConnectTarget() {
        return connectTarget;
    }

    /**
     * Returns the char piece at the spot of the grid
     *
     * @param row the row of the grid
     * @param column the column of the grid
     * @return the char piece at the spot of the grid
     */
    public char getPiece(int row, int column) {
        return grid[row][column];
    }

    /**
     * Returns the ConnectFour game grid
     * @return the ConnectFour game grid
     */
    public char[][] getGrid() {
        return grid;
    }


    /**
     * Drops the piece into the downmost available row of a certain column
     * The spot is available if it does not have a chip (is a "-")
     * Returns true if the piece could be dropped, false if not
     * Throws an IllegalStateException with the message
     * "playerState is neither 1 nor 2" if playerState is neither 1 nor 2
     *
     * @param column the column the chip will be dropped in
     * @return true if the piece could be dropped, false if not
     * @throws IllegalStateException with the message
     * "playerState is neither 1 nor 2" if playerState is neither 1 nor 2
     */
    public boolean dropPiece(int column) {
        for (int i = gridSize - 1; i >= 0; i--) {
            if (grid[i][column] == '-') {
                if (playerState == 1) {
                    grid[i][column] = 'X';
                    player1.incrementPiecesPlaced();
                    playerState = 2;
                    return true;
                } else if (playerState == 2) {
                    grid[i][column] = 'O';
                    player2.incrementPiecesPlaced();
                    playerState = 1;
                    return true;
                } else {
                    throw new IllegalStateException("playerState is neither 1 nor 2");
                }
            }
        }
        return false;
    }

    /**
     * Returns longest connection of a symbol among all axis (horizontal, vertical, diagonal)
     *
     * @param symbol in the spot, for which chip is dropped
     * @return the max connection length of a symbol among all axis
     */
    public int maxConnection(char symbol) {
        int maxStraight = Math.max(maxHorizontalConnection(symbol), maxVerticalConnection(symbol));
        int maxDiagonal = Math.max(maxDownRightConnection(symbol), maxDownLeftConnection(symbol));
        return Math.max(maxStraight, maxDiagonal) == 0 ? 1 : Math.max(maxStraight, maxDiagonal);
    }

    /**
     * Determines the maximum consecutive symbols in each row
     * The connection count increments if the two or more neighboring chips are the same
     *
     * @param symbol in the spot, for which chip is dropped
     * @return the size of the longest horizontal connection
     */
    public int maxHorizontalConnection(char symbol) {
        int maxConnection = 0; // keeps track of the longest connection length
        for (int i = 0; i < gridSize; i++) { // rows
            int connectionCount = 1; // the connection count to be incremented
            // initialized as 1 because every chip is a length of 1 by themselves
            for (int j = 0; j < gridSize - 1; j++) { // columns
                // if two consecutive symbols are both the same as the symbol argument
                if (grid[i][j] == grid[i][j + 1] && grid[i][j] == symbol) {
                    connectionCount += 1; // add 1 to the current connection length
                    maxConnection = Math.max(connectionCount, maxConnection);
                    // update maxConnection if connectionCount is greater
                } else {
                    connectionCount = 1; // reset connectionCount because the streak is broken
                }
            }
        }
        return maxConnection;
    }

    /**
     * Determines the maximum consecutive symbols in each column
     * The connection count increments if the two or more neighboring chips are the same
     *
     * @param symbol in the spot, for which chip is dropped
     * @return the size of the longest vertical connection
     */
    public int maxVerticalConnection(char symbol) {
        int maxConnection = 0; // keeps track of the longest connection length
        for (int i = 0; i < gridSize; i++) { // columns
            int connectionCount = 1; // the connection count to be incremented
            // initialized as 1 because every chip is a length of 1 by themselves
            for (int j = 0; j < gridSize - 1; j++) { // rows
                if (grid[j][i] == grid[j + 1][i] && grid[j][i] == symbol) {
                    // if two consecutive symbols are both the same as the symbol argument
                    connectionCount += 1; // add 1 to the current connection length
                    maxConnection = Math.max(connectionCount, maxConnection);
                    // update maxConnection if connectionCount is greater
                } else {
                    connectionCount = 1; // reset connectionCount because the streak is broken
                }
            }
        }
        return maxConnection;
    }

    /**
     * Determines if two chips diagonal to each other are equal
     * in the down and right direction
     * The connection updates if the two chips are the same
     *
     * @param symbol in the spot, for which chip is dropped
     * @return the max connection of the longest diagonal connection
     * in the down and right direction
     */
    public int maxDownRightConnection(char symbol) {
        int maxConnection = 0; // keeps track of the longest connection length
        for (int i = gridSize; i > 0; i--) { // size of the diagonal
            int connectionCount1 = 1; // the connection count to be incremented
            int connectionCount2 = 1; // the connection count to be incremented
            // initialized as 1 because every chip is a length of 1 by themselves
            for (int j = 0; j < i - 1; j++) { //
                if (grid[j][j + (gridSize - i)] == grid[j + 1][j + (gridSize - i) + 1]
                                            && grid[j][j + (gridSize - i)] == symbol) {
                    // if two consecutive symbols are both the same as the symbol argument
                    connectionCount1 += 1; // add 1 to the current connection length
                    maxConnection = Math.max(connectionCount1, maxConnection);
                    // update maxConnection if connectionCount is greater
                } else {
                    connectionCount1 = 1; // reset connectionCount because the streak is broken
                }
                if (grid[j + (gridSize - i)][j] == grid[j + (gridSize - i) + 1][j + 1]
                                            && grid[j + (gridSize - i)][j] == symbol) {
                    // if two consecutive symbols are both the same as the symbol argument
                    connectionCount2 += 1; // add 1 to the current connection length
                    maxConnection = Math.max(connectionCount2, maxConnection);
                    // update maxConnection if connectionCount is greater
                } else {
                    connectionCount2 = 1; // reset connectionCount because the streak is broken
                }
            }
        }
        return maxConnection;
    }

    /**
     * Determines if two chips diagonal to each other are equal
     * in the down and left direction
     * The connection updates if the two chips are the same
     *
     * @param symbol in the spot, for which chip is dropped
     * @return the max connection of the longest diagonal connection
     * in the down and left direction
     */
    public int maxDownLeftConnection(char symbol) {
        int maxConnection = 0; // keeps track of the longest connection length
        for (int i = 0; i < gridSize; i++) { // size of the diagonal
            int connectionCount1 = 1; // the connection count to be incremented
            int connectionCount2 = 1; // the connection count to be incremented
            // initialized as 1 because every chip is a length of 1 by themselves
            for (int j = gridSize - 1; j > i; j--) { //
                if (grid[j - i][gridSize - 1 - j] == grid[j - i - 1][gridSize - 1 - j + 1]
                                                && grid[j - i][gridSize - 1 - j] == symbol) {
                    // if two consecutive symbols are both the same as the symbol argument
                    connectionCount1 += 1; // add 1 to the current connection length
                    maxConnection = Math.max(connectionCount1, maxConnection);
                    // update maxConnection if connectionCount is greater
                } else {
                    connectionCount1 = 1; // reset connectionCount because the streak is broken
                }
                if (grid[j][gridSize - 1 + i - j] == grid[j - 1][gridSize + i - j]
                                                && grid[j][gridSize - 1 + i - j] == symbol) {
                    // if two consecutive symbols are both the same as the symbol argument
                    connectionCount2 += 1; // add 1 to the current connection length
                    maxConnection = Math.max(connectionCount2, maxConnection);
                    // update maxConnection if connectionCount is greater
                } else {
                    connectionCount2 = 1; // reset connectionCount because the streak is broken
                }
            }
        }
        return maxConnection;
    }

    /**
     * Returns the winning player of the game
     * Based on which player made any max connection of at least 4
     * @return the winning player of the game, null if no one has won
     */
    public Player winner() {
        if (maxConnection('X') >= connectTarget) {
            return player1;
        } else if (maxConnection('O') >= connectTarget) {
            return player2;
        } else {
            return null;
        }
    }

    /**
     * Resets the entire grid and the number of pieces placed,
     * and increments the number of games won by 1 to the player that won the game
     */
    public void reset() {
        if (maxConnection('X') >= connectTarget) {
            player1.incrementGamesWon();
        } else if (maxConnection('O') >= connectTarget) {
            player2.incrementGamesWon();
        }
        grid = new char[gridSize][gridSize];
        for (int i = gridSize - 1; i >= 0; i--) {
            for (int j = gridSize - 1; j >= 0; j--) {
                grid[i][j] = '-';
            }
        }
        playerState = 1;
        player1.resetPiecesPlaced();
        player2.resetPiecesPlaced();
    }
}
