
public class PathWithMinimumEffort {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = (int) 1e6;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (dfs(0, 0, heights, new boolean[heights.length][heights[0].length], mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean dfs(int row, int col, int[][] heights, boolean[][] visited, int limit) {
        if (row == heights.length - 1 && col == heights[row].length - 1) {
            return true;
        }
        for (int[] dir : dirs) {
            int row1 = row + dir[0];
            int col1 = col + dir[1];
            if (row1 >= 0 && row1 < heights.length
                    && col1 >= 0 && col1 < heights[row1].length
                    && !visited[row1][col1] && Math.abs(heights[row][col] - heights[row1][col1]) <= limit) {
                visited[row1][col1] = true;
                if (dfs(row1, col1, heights, visited, limit)) {
                    visited[row1][col1] = false;
                    return true;
                }
                visited[row1][col1] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort pwme = new PathWithMinimumEffort();
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(pwme.minimumEffortPath(heights));
    }
}
