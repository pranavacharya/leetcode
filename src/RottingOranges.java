
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    total++;
                }
            }
        }
        if (total == 0) {
            return 0;
        }
        int min = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            min++;
            while (size > 0) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                for (int[] dir : dirs) {
                    if (x + dir[0] >= 0 && x + dir[0] < grid.length
                            && y + dir[1] >= 0 && y + dir[1] < grid[x + dir[0]].length
                            && grid[x + dir[0]][y + dir[1]] == 1) {
                        grid[x + dir[0]][y + dir[1]] = 2;
                        queue.add(new int[]{x + dir[0], y + dir[1]});
                        total--;
                    }
                }
                size--;
            }
        }
        return total == 0 ? min - 1 : -1;
    }

    public static void main(String args[]) {
        RottingOranges ro = new RottingOranges();
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(ro.orangesRotting(grid));
    }
}
