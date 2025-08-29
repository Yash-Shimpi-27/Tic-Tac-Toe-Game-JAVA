
import java.util.Scanner;

public class TicTacToe {

    // The grid where the game is played, represented as a 2D array
    private static char[][] grid = new char[3][3];

    // The players, represented as X and O
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    // The current player
    private static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {
        // Initialize the grid with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }

        // Start the game loop
        while (true) {
            // Print the grid
            printGrid();

            // Prompt the current player to make a move
            System.out.println("Player " + currentPlayer + ", enter your move (row, col): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Update the grid with the player's move
            grid[row][col] = currentPlayer;

            // Check if the game is over
            if (isGameOver()) {
                // Print the final grid
                printGrid();

                // Print the winner (if any)
                if (hasWinner()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    System.out.println("It's a tie!");
                }

                // End the game loop
                break;
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }
    }

    // Print the grid to the console
    private static void printGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-+-+-");
            }
        }
    }

    // Check if the game is over (i.e. someone has won or there are no more empty spaces)
    private static boolean isGameOver() {
        return hasWinner() || isFull();
    }

    // Check if there is a winner (i.e. someone has three marks in a row)
    private static boolean hasWinner() {
        // Check for horizontal wins
        for (int i = 0; i < 3; i++) {
            if (isRowWin(i)) {
                return true;
            }
        }

        // Check for vertical wins
        for (int i = 0; i < 3; i++) {
            if (isColWin(i)) {
                return true;
            }
        }

        // Check for diagonal wins
        if (isDiag1Win() || isDiag2Win()) {
            return true;
        }

        // If none of the above checks passed, there is no winner
        return false;
    }

    // Check if the given row has a winning combination
    private static boolean isRowWin(int row) {
        return (grid[row][0] != ' ' && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]);
    }

    // Check if the given column has a winning combination
    private static boolean isColWin(int col) {
        return (grid[0][col] != ' ' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]);
    }

    // Check if the first diagonal has a winning combination
    private static boolean isDiag1Win() {
        return (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]);
    }

    // Check if the second diagonal has a winning combination
    private static boolean isDiag2Win() {
        return (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]);
    }

    // Check if there are no more empty spaces in the grid
    private static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
