package org.example.games;

import java.util.*;

/**
 * A simple console-based Tic-Tac-Toe game where a player competes against the computer.
 * <p>
 * Features:
 * <ul>
 *   <li>Player chooses their symbol (X or O)</li>
 *   <li>Random toss decides who plays first</li>
 *   <li>Game alternates between player and computer turns</li>
 *   <li>Detects win, loss, or tie</li>
 *   <li>Supports multiple games with "Play Again" option</li>
 * </ul>
 */
class TicTacToe {

    static final char PLAY_AGAIN_YES = 'Y';
    static final char PLAY_AGAIN_NO = 'N';
    static final int PLAYER = 1;
    static final int COMPUTER = 0;
    static char symbol;
    static char player_symbol;
    static char computer_symbol;
    static char[] board;
    static Scanner sc = new Scanner(System.in);

    /**
     * Displays a sample board with numbered positions (1-9).
     * Helps players understand which number corresponds to which cell.
     */
    public static void creating_Board_UC1() {
        System.out.println("Board with number positions:");
        for (int i = 1; i < board.length; i++) {
            System.out.println(i + "|" + (++i) + "|" + (++i));
            System.out.println("-+-+-");
        }
    }

    /**
     * Allows the player to choose their symbol (X or O).
     * Assigns the opposite symbol to the computer.
     */
    public static void choose_X_O_UC2() {
        while (true) {
            System.out.println("Choose your symbol: X or O");
            symbol = sc.next().charAt(0);
            if (symbol == 'X' || symbol == 'x') {
                player_symbol = 'X';
                computer_symbol = 'O';
                System.out.println("You chose " + player_symbol);
                System.out.println("Computer gets " + computer_symbol);
                break;
            } else if (symbol == 'O' || symbol == 'o') {
                player_symbol = 'O';
                computer_symbol = 'X';
                System.out.println("You chose " + player_symbol);
                System.out.println("Computer gets " + computer_symbol);
                break;
            } else {
                System.out.println("Invalid input. Please choose X or O.");
            }
        }
    }

    /**
     * Displays the current game board with player and computer moves.
     */
    public static void showBoard() {
        for (int i = 1; i < board.length; i++) {
            System.out.println(board[i] + "|" + board[(++i)] + "|" + board[(++i)]);
            System.out.println("-+-+-");
        }
    }

    /**
     * Toss to decide who plays first (Player or Computer).
     * Alternates turns until the game finishes.
     */
    public static void tossForGame() {
        Random rand1 = new Random();
        int toss = rand1.nextInt(2);
        if (toss == PLAYER) {
            System.out.println("Player won the toss!");
            while (true) {
                playerTurn();
                if (isGameFinished()) break;
                computerTurn();
                if (isGameFinished()) break;
            }
        } else {
            System.out.println("Computer won the toss!");
            while (true) {
                computerTurn();
                if (isGameFinished()) break;
                playerTurn();
                if (isGameFinished()) break;
            }
        }
    }

    /**
     * Places a symbol (X or O) on the board at the given position.
     *
     * @param position board index (1-9)
     * @param symbol   player's or computer's symbol
     */
    public static void placeMove(int position, char symbol) {
        if (position >= 1 && position <= 9) {
            board[position] = symbol;
        }
        showBoard();
    }

    /**
     * Checks if the chosen board position is empty and valid.
     *
     * @param position position on the board (1-9)
     * @return true if the move is valid, false otherwise
     */
    public static boolean isValidMove(int position) {
        return position >= 1 && position <= 9 && board[position] == ' ';
    }

    /**
     * Handles the player's turn by taking input and placing the move.
     */
    public static void playerTurn() {
        int playerInput;
        while (true) {
            System.out.println("Enter your move (1-9): ");
            playerInput = sc.nextInt();
            if (isValidMove(playerInput)) {
                break;
            } else {
                System.out.println(playerInput + " is not a valid move. Try again.");
            }
        }
        placeMove(playerInput, player_symbol);
    }

    /**
     * Handles the computer's turn by choosing a random valid position.
     */
    public static void computerTurn() {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(computerMove)) {
                break;
            }
        }
        System.out.println("Computer chose position " + computerMove);
        placeMove(computerMove, computer_symbol);
    }

    /**
     * Checks if the given symbol (X or O) has won the game.
     *
     * @param symbol symbol of the player or computer
     * @return true if the symbol has a winning combination
     */
    public static boolean hasContestantWon(char symbol) {
        return ((board[1] == symbol && board[2] == symbol && board[3] == symbol) ||
                (board[4] == symbol && board[5] == symbol && board[6] == symbol) ||
                (board[7] == symbol && board[8] == symbol && board[9] == symbol) ||

                (board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
                (board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
                (board[3] == symbol && board[6] == symbol && board[9] == symbol) ||

                (board[1] == symbol && board[5] == symbol && board[9] == symbol) ||
                (board[3] == symbol && board[5] == symbol && board[7] == symbol));
    }

    /**
     * Checks if the game has finished due to a win or a tie.
     *
     * @return true if game ends, false otherwise
     */
    public static boolean isGameFinished() {
        if (hasContestantWon(player_symbol)) {
            System.out.println("Player wins!");
            return true;
        }
        if (hasContestantWon(computer_symbol)) {
            System.out.println("Computer wins!");
            return true;
        } else {
            for (int i = 1; i < board.length; i++) {
                if (board[i] == ' ') {
                    return false; // game still ongoing
                }
            }
            System.out.println("The game ended in a tie!");
            return true;
        }
    }

    /**
     * Main method to run the Tic-Tac-Toe game.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char playAgain;
        while (true) {
            board = new char[10];
            Arrays.fill(board, ' ');
            creating_Board_UC1();
            choose_X_O_UC2();
            tossForGame();
            System.out.println("Do you want to play again? (Y/N)");
            playAgain = s.next().charAt(0);
            if (playAgain == PLAY_AGAIN_NO) {
                break;
            }
        }
    }
}
