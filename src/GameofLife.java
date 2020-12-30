
import java.util.Arrays;

public class GameofLife {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = 0;
                for (int[] dir : dirs) {
                    if (i + dir[0] >= 0 && i + dir[0] < board.length
                            && j + dir[1] >= 0 && j + dir[1] < board[i].length) {
                        if (board[i + dir[0]][j + dir[1]] == 1) {
                            live++;
                        }
                    }
                }
                if (board[i][j] == 0 && live == 3) {
                    ans[i][j] = 1;
                } else if (board[i][j] == 1 && live < 2) {
                    ans[i][j] = 0;
                } else if (board[i][j] == 1 && live < 4) {
                    ans[i][j] = 1;
                } else if (board[i][j] == 1 && live > 3) {
                    ans[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    public static void main(String args[]) {
        GameofLife gl = new GameofLife();
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gl.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
