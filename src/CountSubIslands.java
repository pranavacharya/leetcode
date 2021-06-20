
public class CountSubIslands {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1 && !visited[i][j] && grid1[i][j] == 1) {
                    if (isSubIsland(grid1, grid2, i, j, visited, new boolean[grid1.length][grid1[0].length])) {
                        // System.out.println("i " + i + " j" + j);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j, boolean[][] visited, boolean[][] path) {
        visited[i][j] = true;
        path[i][j] = true;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x >= 0 && x < grid2.length && y >= 0 && y < grid2[x].length && grid2[x][y] == 1 && !path[x][y]) {
                if (grid1[x][y] == 0) {
                    return false;
                } else {
                    if (!isSubIsland(grid1, grid2, x, y, visited, path)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountSubIslands csi = new CountSubIslands();
        int[][] grid1 = new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0},
        {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(csi.countSubIslands(grid1, grid2));
    }
}
