
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList();
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        queue.add(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) {
                    return ans;
                }
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length) {
                        if (grid[x][y] == 0 && !visited[x][y][curr[2]]) {
                            queue.add(new int[]{x, y, curr[2]});
                            visited[x][y][curr[2]] = true;
                        }
                        if (grid[x][y] == 1 && curr[2] > 0 && !visited[x][y][curr[2] - 1]) {
                            queue.add(new int[]{x, y, curr[2] - 1});
                            visited[x][y][curr[2] - 1] = true;
                        }
                    }
                }
                size--;
            }
            ans++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathinaGridwithObstaclesElimination spgwoe = new ShortestPathinaGridwithObstaclesElimination();
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        System.out.println(spgwoe.shortestPath(grid, 1));
    }
}
