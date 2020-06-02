
import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {

    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.size() == 0 || queue.size() == m * n) {
            return -1;
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            max++;
        }
        return max - 1;
    }

    public static void main(String args[]) {
        AsFarfromLandasPossible afflp = new AsFarfromLandasPossible();
        int[][] grid = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(afflp.maxDistance(grid));
    }
}
