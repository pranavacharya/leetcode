
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int seconds = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    if (curr[0] + dir[0] < m && curr[0] + dir[0] >= 0
                            && curr[1] + dir[1] < n && curr[1] + dir[1] >= 0
                            && grid[curr[0] + dir[0]][curr[1] + dir[1]] == 1) {
                        queue.add(new int[]{curr[0] + dir[0], curr[1] + dir[1]});
                        grid[curr[0] + dir[0]][curr[1] + dir[1]] = 2;
                    }
                }
                size--;
            }
            seconds++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return seconds > 0 ? seconds - 1 : 0;
    }

    public static void main(String args[]) {
        RottingOranges ro = new RottingOranges();
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(ro.orangesRotting(grid));
    }
}
