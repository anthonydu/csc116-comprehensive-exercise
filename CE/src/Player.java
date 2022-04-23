/**
 * A player of the Connect Four game
 * @author Anthony Du
 * @author Bowen Deng
 * @author Om Pandey
 * @author Shuhao Liu
 */
public class Player {

    /** The name of the player */
    private String name;

    /** The number of games won */
    private int gamesWon;

    /** The number of pieces placed */
    private int piecesPlaced;

    /**
     * Constructs a new Player to assign the name to the instance field
     * and to initialize the number of games won and pieces placed to 0
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        gamesWon = 0;
        piecesPlaced = 0;
    }

    /**
     * Returns the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    // "As the players play the game, they should be updated with how many pieces they have placed"

    /**
     * Returns the number of pieces placed
     * @return the number of pieces placed
     */
    public int getPiecesPlaced() {
        return piecesPlaced;
    }

    /**
     * Returns the number of games won
     * @return the number of games won
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Increases the number of pieces placed by 1
     * for whenever this method is called
     */
    public void incrementPiecesPlaced() {
        piecesPlaced += 1;
    }

    /**
     * Increases the number of games won by 1
     * for whenever this method is called
     */
    public void incrementGamesWon() {
        gamesWon += 1;
    }

    /**
     * Resets the number of pieces placed to 0
     */
    public void resetPiecesPlaced() {
        piecesPlaced = 0;
    }
}
