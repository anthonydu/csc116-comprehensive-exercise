import java.util.Scanner;

/**
 * A visual representation of a Connect Four Game
 * @author Anthony Du
 * @author Bowen Deng
 * @author Om Pandey
 * @author Shuhao Liu
 */
public class ConnectFourUI {

    /**
     * Starts the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        ConnectFour game;
        final int FOUR = 4;
        final int FORTY_NINE = 49;

        System.out.println();
        System.out.println("Welcome to Connect Four!");
        System.out.println("(enter \"q\" to exit game)");
        System.out.println();

        while (true) {
            System.out.print("Please type in the required connection length to win: ");
            if (console.hasNextInt()) {
                int connectTarget = console.nextInt();
                if (connectTarget < FOUR || connectTarget > FORTY_NINE) {
                    System.out.println();
                    System.out.print("Invalid input! ");
                    System.out.println("Please enter an integer between 4 and 49!");
                    System.out.println();
                    continue;
                } else {
                    game = new ConnectFour(connectTarget, player1, player2);
                    break;
                }
            } else if (console.next().equals("q")) {
                System.exit(0);
            } else {
                System.out.println();
                System.out.print("Invalid input! ");
                System.out.println("Please enter an integer between 4 and 49!");
                System.out.println();
            }
        }

        while (true) {

            game.reset();

            System.out.println();
            printGrid(game);
            System.out.println();

            while (game.winner() == null) {
                int nextColumn;
                while (true) {
                    if (game.getPlayerState() == 1) {
                        System.out.print(player1.getName()
                                    + ", enter the column you want to drop your next chip in: ");
                    }
                    if (game.getPlayerState() == 2) {
                        System.out.print(player2.getName()
                                    + ", enter the column you want to drop your next chip in: ");
                    }
                    if (console.hasNextInt()) {
                        nextColumn = console.nextInt() - 1;
                        if (nextColumn < 0 || nextColumn >= game.getGridSize()) {
                            System.out.println();
                            System.out.print("Invalid input! ");
                            System.out.print("Please enter an integer between 1 and ");
                            System.out.println(game.getGridSize() + "!");
                            System.out.println();
                            continue;
                        } else {
                            break;
                        }
                    } else if (console.next().equals("q")) {
                        System.exit(0);
                    } else {
                        System.out.println();
                        System.out.print("Invalid input! ");
                        System.out.print("Please enter an integer between 1 and ");
                        System.out.println(game.getGridSize() + "!");
                        System.out.println();
                    }
                }

                if (game.dropPiece(nextColumn)) {
                    System.out.println();
                    printGrid(game);
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("Failed to drop piece! Please enter another row number!");
                    System.out.println();
                }
            }

            System.out.println(game.winner().getName() + ", you are the winner!");
            System.out.println();
            System.out.println("A new game has started.");
        }
    }

    /**
     * Prints the whole 2D Connect Fourt grid
     * @param game the object of the ConnectFour class
     */
    private static void printGrid(ConnectFour game) {
        System.out.print("\t");
        for (int i = 0; i < game.getGridSize(); i++) {
            if ((i + 1) < 10) {
                System.out.print((i + 1) + "  ");
            } else {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < game.getGridSize(); i++) {
            System.out.print("\t");
            for (int j = 0; j < game.getGridSize(); j++) {
                System.out.print(game.getPiece(i, j) + "  ");
            }
            switch ("" + i) { // I blame this on checkstyle
                case "0":
                    System.out.print("\t" + game.getPlayer1().getName() + " (X)" + ":");
                    break;
                case "1":
                    System.out.print("\t\tGames won:             ");
                    System.out.print(game.getPlayer1().getGamesWon());
                    break;
                case "2":
                    System.out.print("\t\tPieces placed:         ");
                    System.out.print(game.getPlayer1().getPiecesPlaced());
                    break;
                case "3":
                    System.out.print("\t\tMax connection length: " + game.maxConnection('X'));
                    break;
                case "4":
                    System.out.print("\t" + game.getPlayer2().getName() + " (O)" + ":");
                    break;
                case "5":
                    System.out.print("\t\tGames won:             ");
                    System.out.print(game.getPlayer2().getGamesWon());
                    break;
                case "6":
                    System.out.print("\t\tPieces placed:         ");
                    System.out.print(game.getPlayer2().getPiecesPlaced());
                    break;
                case "7":
                    System.out.print("\t\tMax connection length: " + game.maxConnection('O'));
                    break;
                default: // nothing to do... cuz... checkstyle...
            }
            System.out.println();
        }
    }
}
