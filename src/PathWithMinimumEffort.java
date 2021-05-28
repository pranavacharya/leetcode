
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinimumEffort {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = (int) 1e6;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (bfs(heights, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean bfs(int[][] heights, int limit) {
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == heights.length - 1 && curr[1] == heights[curr[0]].length - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                if (row >= 0 && row < heights.length
                        && col >= 0 && col < heights[row].length
                        && !visited[row][col] && limit >= Math.abs(heights[curr[0]][curr[1]] - heights[row][col])) {
                    visited[row][col] = true;
                    queue.add(new int[]{row, col});
                }
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
