
public class UniquePaths3 {

    private int count;

    public UniquePaths3() {
        this.count = 0;
    }

    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -2;
                    backtrack(grid, i, j);
                    break;
                }
            }
        }
        return this.count;
    }

    public void backtrack(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1) {
            return;
        } else if (grid[i][j] == 2) {
            int visited = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == -1) {
                        visited++;
                    }
                }
            }
            if (visited + 1 == grid.length * grid[0].length) {
                this.count++;
            }
        } else if (grid[i][j] == 0 || grid[i][j] == -2) {
            grid[i][j] = -1;
            //top
            backtrack(grid, i, j - 1);
            //bottom
            backtrack(grid, i, j + 1);
            //left
            backtrack(grid, i - 1, j);
            //right
            backtrack(grid, i + 1, j);
            grid[i][j] = 0;
        }
    }

    public static void main(String args[]) {
        UniquePaths3 up3 = new UniquePaths3();
        int[][] grid = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(up3.uniquePathsIII(grid));
    }
}
