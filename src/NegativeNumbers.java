
public class NegativeNumbers {

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0, end = grid[0].length; i < grid.length; i++) {
            for (int j = 0; j < end; j++) {
                if (grid[i][j] < 0) {
                    count = count + ((grid.length - i) * (end - j));
                    end = j;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int[][] grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        NegativeNumbers nn = new NegativeNumbers();
        System.out.println(nn.countNegatives(grid));
    }
}
