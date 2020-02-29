
public class NumberOfIslands {

    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int num = 0;
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.grid[i][j] == '1') {
                    clearIsland(i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void clearIsland(int i, int j) {
        if (i < 0 || j < 0 || i > this.grid.length - 1 || j > this.grid[i].length - 1) {
            return;
        }
        if (this.grid[i][j] == '1') {
            this.grid[i][j] = '0';
            clearIsland(i, j + 1); //right
            clearIsland(i + 1, j); //bottom
            clearIsland(i, j - 1); //left
            clearIsland(i - 1, j); //top
        }
    }

    public static void main(String args[]) {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grid = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'},
        {'1', '1', '1', '0', '1'}};
        System.out.println(noi.numIslands(grid));
    }
}
