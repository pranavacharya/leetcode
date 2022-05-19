
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

    private int[][] dirs = new int[][]{{1, 1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        }
        boolean[][] visited = new boolean[grid.length][grid.length];
        int ans = 0;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size > 0) {
                int[] curr = queue.poll();

                if (curr[0] == grid.length - 1 && curr[1] == grid.length - 1) {
                    return ans;
                }
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if (x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid.length - 1 && grid[x][y] == 0) {
                        if (!visited[x][y]) {
                            visited[x][y] = true;
                            queue.add(new int[]{x, y});
                        }
                    }

                }

                size--;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        ShortestPathinBinaryMatrix spbm = new ShortestPathinBinaryMatrix();
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 0}, {1, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 0, 0, 0}};
        System.out.println(spbm.shortestPathBinaryMatrix(grid));
    }
}
