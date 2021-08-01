
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        int color = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int size = helper(grid, i, j, color);
                    map.put(color, size);
                    color++;
                }
            }
        }
        int result = map.getOrDefault(2, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i > 0 ? grid[i - 1][j] : 0);
                    set.add(i < grid.length - 1 ? grid[i + 1][j] : 0);
                    set.add(j > 0 ? grid[i][j - 1] : 0);
                    set.add(j < grid.length - 1 ? grid[i][j + 1] : 0);
                    int newSize = 1;
                    for (int c : set) {
                        newSize += map.get(c);
                    }
                    result = Math.max(result, newSize);
                }
            }
        }
        return result;
    }

    private int helper(int[][] grid, int i, int j, int color) {
        int ans = 1;
        grid[i][j] = color;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1) {
                ans += helper(grid, x, y, color);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MakingALargeIsland mali = new MakingALargeIsland();
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        System.out.println(mali.largestIsland(grid));
    }
}
