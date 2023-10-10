package Tugaskucoba1;
import java.util.Scanner;

public class P33 {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        char currentPlayer = 'X';
        boolean gameWon = false;

        printBoard(board);

        while (!gameWon) {
            int[] move = getPlayerMove(board, currentPlayer);
            int row = move[0];
            int col = move[1];

            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
                printBoard(board);

                if (checkWin(board, currentPlayer)) {
                    System.out.println("Pemain " + currentPlayer + " menang!");
                    gameWon = true;
                } else if (isBoardFull(board)) {
                    System.out.println("Yah seriii!");
                    gameWon = true;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Langkah anda tidak valid. Coba lagi.");
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static int[] getPlayerMove(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.print("Pemain " + currentPlayer + ", silahkan jalan,giliranmu (row and column): ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        return move;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Check baris
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Check kolom
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Check diagonal (kiri atas ke kanan bawah)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Check diagonal (kanan atas ke kiri bawah)
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
