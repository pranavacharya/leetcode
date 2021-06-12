
public class LargestMagicSquare {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ml = Math.min(m, n);
        int[][] v = new int[m + 1][n + 1];
        int[][] h = new int[m + 1][n + 1];
        int[][] ld = new int[m + 1][n + 1];
        int[][] rd = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                h[i + 1][j + 1] = h[i + 1][j] + grid[i][j];
                v[i + 1][j + 1] = v[i][j + 1] + grid[i][j];
                ld[i + 1][j + 1] = ld[i][j] + grid[i][j];
                rd[m - i - 1][n - j] = rd[m - i][n - j - 1] + grid[m - i - 1][n - j - 1];
            }
        }
        for (int l = ml; l > 0; l--) {
            for (int i = l - 1; i < m; i++) {
                for (int j = l - 1; j < n; j++) {
                    boolean areRowsValid = true;
                    int effectiveRowSum = h[i + 1][j + 1] - h[i + 1][j + 1 - l];
                    for (int k = i - l + 1; k < i; k++) {
                        if (h[k + 1][j + 1] - h[k + 1][j + 1 - l] != effectiveRowSum) {
                            areRowsValid = false;
                            break;
                        }
                    }

                    if (!areRowsValid) {
                        continue;
                    }

                    boolean areColsValid = true;
                    int effectiveColSum = v[i + 1][j + 1] - v[i - l + 1][j + 1];
                    if (effectiveColSum != effectiveRowSum) {
                        continue;
                    }
                    for (int k = j - l + 1; k < j; k++) {
                        if (v[i + 1][k + 1] - v[i + 1 - l][k + 1] != effectiveColSum) {
                            areColsValid = false;
                            break;
                        }
                    }

                    if (!areColsValid) {
                        continue;
                    }

                    int diaSum = ld[i + 1][j + 1] - ld[i + 1 - l][j + 1 - l];
                    int antiDiaSum = rd[i + 1 - l][j + 1] - rd[i + 1][j + 1 - l];
                    if (diaSum == effectiveColSum && diaSum == antiDiaSum) {
                        return l;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LargestMagicSquare lms = new LargestMagicSquare();
        int[][] grid = new int[][]{{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4},
        {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};
        System.out.println(lms.largestMagicSquare(grid));
    }
}
