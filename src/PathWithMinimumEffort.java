
public class PathWithMinimumEffort {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int min;

    public int minimumEffortPath(int[][] heights) {
        this.min = Integer.MAX_VALUE;
        dfs(0, 0, heights, new boolean[heights.length][heights[0].length], 0);
        return this.min;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] visited, int sum) {
        if (sum > this.min) {
            return;
        }
        if (row == heights.length - 1 && col == heights[row].length - 1) {
            min = Math.min(min, sum);
        }
        for (int[] dir : dirs) {
            int row1 = row + dir[0];
            int col1 = col + dir[1];
            if (row1 >= 0 && row1 < heights.length
                    && col1 >= 0 && col1 < heights[row1].length
                    && !visited[row1][col1]) {
                visited[row1][col1] = true;
                dfs(row1, col1, heights, visited,
                        Math.max(sum, Math.abs(heights[row][col] - heights[row1][col1])));
                visited[row1][col1] = false;
            }
        }
    }

    public static void main(String[] args) {
        PathWithMinimumEffort pwme = new PathWithMinimumEffort();
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(pwme.minimumEffortPath(heights));
    }
}
