
import java.util.ArrayList;

public class LongestIncreasingPathinaMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int longestPath = 0;

    public int longestIncreasingPath(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j, new ArrayList());
            }
        }
        return longestPath;
    }

    private void dfs(int[][] matrix, int row, int col, ArrayList<Integer> path) {
        this.longestPath = Math.max(this.longestPath, path.size() + 1);

        for (int[] dir : dirs) {

            if (row + dir[0] >= 0 && row + dir[0] < matrix.length && col + dir[1] >= 0
                    && col + dir[1] < matrix[0].length
                    && matrix[row + dir[0]][col + dir[1]] > matrix[row][col]) {
                path.add(matrix[row][col]);
                dfs(matrix, row + dir[0], col + dir[1], path);
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        LongestIncreasingPathinaMatrix lipm = new LongestIncreasingPathinaMatrix();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(lipm.longestIncreasingPath(matrix));
    }
}
