import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Player class
 * @author Anthony Du
 * @author Bowen Deng
 * @author Om Pandey
 * @author Shuhao Liu
 */
public class PlayerTest {

    /** The Player class object */
    private Player player;

    /**
     * Set up fields
     */
    @BeforeEach
    public void setUp() {
        player = new Player("player name");
    }

    /**
     * Tests getName method
     */
    @Test
    public void testGetName() {
        assertEquals("player name", player.getName(), "Test getName");
    }

    /**
     * Tests dropPiece and getPiece method
     */
    @Test
    public void testPiecesPlaced() {
        player.incrementPiecesPlaced();
        assertEquals(1, player.getPiecesPlaced(), "Test piecesPlaced 1");
        player.incrementPiecesPlaced();
        assertEquals(2, player.getPiecesPlaced(), "Test piecesPlaced 2");
        player.incrementPiecesPlaced();
        assertEquals(3, player.getPiecesPlaced(), "Test piecesPlaced 3");
    }

    /**
     * Tests getGamesWon method
     */
    @Test
    public void testGamesWon() {
        player.incrementGamesWon();
        assertEquals(1, player.getGamesWon(), "Test gamesWon 1");
        player.incrementGamesWon();
        assertEquals(2, player.getGamesWon(), "Test gamesWon 2");
        player.incrementGamesWon();
        assertEquals(3, player.getGamesWon(), "Test gamesWon 3");
    }
}
