import java.util.Scanner;

public class NB20 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ange n: ");
        int n = scan.nextInt();
        int[] board = new int[n];
        placeQueen(0, n, board);
        System.out.println("Antal lösningar: " + count);
    }

    public static void placeQueen(int row, int n, int[] board) {
        if (row == n) {
            count++;
            printBoard(board, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row] = col;
                placeQueen(row + 1, n, board);
            }
        }
    }

    public static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}