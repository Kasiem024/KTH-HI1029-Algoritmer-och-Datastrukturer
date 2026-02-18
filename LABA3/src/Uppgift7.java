import java.util.Scanner;

public class Uppgift7 {
    static int n = 5;
    static int[][] board = new int[n][n];
    static int solutionCount = 0;

    // Shapes defined as relative coordinates
    static int[][][] shapes = {
            {{0,0}, {1,0}, {2,0}, {1,1}}, // T up
            {{0,0}, {0,1}, {0,2}, {1,1}}, // T right
            {{0,0}, {1,0}, {2,0}, {1,-1}}, // T down
            {{0,0}, {1,0}, {1,1}, {1,-1}}  // T left
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row and column for gray square (1-5): ");
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        board[r][c] = -1; // Marked square that cannot be covered
        solve(0, 0, 1);
        System.out.println("Total solutions: " + solutionCount);
    }

    static void solve(int r, int c, int pieceNr) {
        if (pieceNr > 6) { // All pieces placed
            solutionCount++;
            printBoard();
            return;
        }

        // Find next empty square
        while (board[r][c] != 0) {
            c++;
            if (c == n) {
                c = 0;
                r++;
            }
            if (r == n) return;
        }

        // Try all four rotations
        for (int[][] shape : shapes) {
            if (canPlace(r, c, shape)) {
                place(r, c, shape, pieceNr);
                solve(r, c, pieceNr + 1);
                place(r, c, shape, 0); // Backtrack
            }
        }
    }

    static boolean canPlace(int r, int c, int[][] shape) {
        for (int[] p : shape) {
            int nr = r + p[0];
            int nc = c + p[1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] != 0) {
                return false;
            }
        }
        return true;
    }

    static void place(int r, int c, int[][] shape, int id) {
        for (int[] p : shape) {
            board[r + p[0]][c + p[1]] = id;
        }
    }

    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}