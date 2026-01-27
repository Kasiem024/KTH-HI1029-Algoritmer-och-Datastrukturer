import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NB19 {

    private static int[] board = {1, 1, 1, 0, 2, 2, 2};
    private static final int[] GOAL = {2, 2, 2, 0, 1, 1, 1};

    public static void main(String[] args) {
        solve(new ArrayList<>());
    }

    private static void solve(List<String> moves) {
        if (Arrays.equals(board, GOAL)) {
            System.out.println(String.join(", ", moves));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i] == 1) {
                if (checkMove(i, i + 1)) {
                    move(i, i + 1, moves);
                    solve(moves);
                    unmove(i, i + 1, moves);
                }
                if (checkJump(i, i + 2)) {
                    move(i, i + 2, moves);
                    solve(moves);
                    unmove(i, i + 2, moves);
                }
            } else if (board[i] == 2) {
                if (checkMove(i, i - 1)) {
                    move(i, i - 1, moves);
                    solve(moves);
                    unmove(i, i - 1, moves);
                }
                if (checkJump(i, i - 2)) {
                    move(i, i - 2, moves);
                    solve(moves);
                    unmove(i, i - 2, moves);
                }
            }
        }
    }

    private static boolean checkMove(int from, int to) {
        return to >= 0 && to < board.length && board[to] == 0;
    }

    private static boolean checkJump(int from, int to) {
        if (to < 0 || to >= board.length || board[to] != 0) return false;
        int mid = (from + to) / 2;
        return board[mid] != 0;
    }

    private static void move(int from, int to, List<String> moves) {
        board[to] = board[from];
        board[from] = 0;
        moves.add((from + 1) + "->" + (to + 1));
    }

    private static void unmove(int from, int to, List<String> moves) {
        board[from] = board[to];
        board[to] = 0;
        moves.remove(moves.size() - 1);
    }
}