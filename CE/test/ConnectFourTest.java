import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests ConnectFour class
 * @author Anthony Du
 * @author Bowen Deng
 * @author Om Pandey
 * @author Shuhao Liu
 */
public class ConnectFourTest {

    /** The ConnectFour class object */
    private ConnectFour connectFour;

    /** The ConnectFour game grid */
    private char[][] grid;

    /** The Player class Player 1 name */
    private Player player1 = new Player("Player1");

    /** The Player class Player 2 name */
    private Player player2 = new Player("Player2");

    /** The initial 2D Connect Four array */
    private char[][] initArray = new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},
                                              {'-', '-', '-', '-', '-', '-', '-', '-'},
                                              {'-', '-', '-', '-', '-', '-', '-', '-'},
                                              {'-', '-', '-', '-', '-', '-', '-', '-'},
                                              {'-', '-', '-', '-', '-', '-', '-', '-'},
                                              {'-', '-', '-', '-', '-', '-', '-', '-'},
                                              {'-', '-', '-', '-', '-', '-', '-', '-'},
                                              {'-', '-', '-', '-', '-', '-', '-', '-'}};

    /**
     * Set up fields
     */
    @BeforeEach
    public void setUp() {
        connectFour = new ConnectFour(4, player1, player2);
    }

    /**
     * Tests getter methods
     */
    @Test
    public void testConstructorGetters() {
        assertEquals(4, connectFour.getConnectTarget(), "Test connectTarget");
        assertEquals(8, connectFour.getGridSize(), "Test gridSize");
        assertEquals(player1, connectFour.getPlayer1(), "Test player1");
        assertEquals(player2, connectFour.getPlayer2(), "Test player2");
        assertArrayEquals(initArray, connectFour.getGrid(), "Test grid");
    }

    /**
     * Tests dropPiece and getPiece method
     */
    @Test
    public void testDropGetPiece() {
        connectFour.dropPiece(7);
        assertEquals('X', connectFour.getPiece(7, 7), "First piece in column 7");
        connectFour.dropPiece(0);
        assertEquals('O', connectFour.getPiece(7, 0), "First piece in column 0");
        connectFour.dropPiece(0);
        assertEquals('X', connectFour.getPiece(6, 0), "Second piece in column 0");
        connectFour.dropPiece(7);
        assertEquals('O', connectFour.getPiece(6, 7), "Second piece in column 7");
    }

    /**
     * Tests maxConnection method
     */
    @Test
    public void testMaxConnection() {
        connectFour.dropPiece(1); // X
        connectFour.dropPiece(0); // O
        connectFour.dropPiece(2); // X
        connectFour.dropPiece(4); // O
        connectFour.dropPiece(2); // X
        connectFour.dropPiece(4); // O
        connectFour.dropPiece(3); // X
        connectFour.dropPiece(4); // O
        connectFour.dropPiece(4); // X
        connectFour.dropPiece(3); // O
        connectFour.dropPiece(5); // X
        connectFour.dropPiece(1); // O
        connectFour.dropPiece(2); // X
        connectFour.dropPiece(1); // O
        connectFour.dropPiece(2); // X
        connectFour.dropPiece(5); // O
        connectFour.dropPiece(5); // X
        connectFour.dropPiece(5); // O
        connectFour.dropPiece(5); // X
        /*{{'-', '-', '-', '-', '-', '-', '-', '-'},
           {'-', '-', '-', '-', '-', '-', '-', '-'},
           {'-', '-', '-', '-', '-', '-', '-', '-'},
           {'-', '-', '-', '-', '-', '-', '-', '-'},
           {'-', '-', 'X', '-', 'X', 'O', '-', '-'},
           {'-', 'O', 'X', 'O', 'O', 'X', '-', '-'},
           {'-', 'O', 'X', 'O', 'O', 'O', '-', '-'},
           {'O', 'X', 'X', 'X', 'O', 'X', '-', '-'}}*/
        assertEquals(4, connectFour.maxConnection('X'),
                    "Test maxConnection('X')");
        assertEquals(3, connectFour.maxConnection('O'),
                    "Test maxConnection('O')");
        assertEquals(8, connectFour.maxConnection('-'),
                    "Test maxConnection('-')");

        assertEquals(3, connectFour.maxHorizontalConnection('X'),
                    "Test maxHorizontalConnection('X')");
        assertEquals(3, connectFour.maxHorizontalConnection('O'),
                    "Test maxHorizontalConnection('O')");
        assertEquals(8, connectFour.maxHorizontalConnection('-'),
                    "Test maxHorizontalConnection('-')");

        assertEquals(4, connectFour.maxVerticalConnection('X'),
                    "Test maxVerticalConnection('X')");
        assertEquals(3, connectFour.maxVerticalConnection('O'),
                    "Test maxVerticalConnection('O')");
        assertEquals(8, connectFour.maxVerticalConnection('-'),
                    "Test maxVerticalConnection('-')");

        assertEquals(2, connectFour.maxDownRightConnection('X'),
                    "Test maxDownRightConnection('X')");
        assertEquals(2, connectFour.maxDownRightConnection('O'),
                    "Test maxDownRightConnection('O')");
        assertEquals(5, connectFour.maxDownRightConnection('-'),
                    "Test maxDownRightConnection('-')");

        assertEquals(2, connectFour.maxDownLeftConnection('X'),
                    "Test maxDownLeftConnection('X')");
        assertEquals(3, connectFour.maxDownLeftConnection('O'),
                    "Test maxDownLeftConnection('O')");
        assertEquals(6, connectFour.maxDownLeftConnection('-'),
                    "Test maxDownLeftConnection('-')");
    }
}
