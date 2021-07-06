
import java.util.Arrays;

public class ReshapetheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[x][y] = mat[i][j];
                y++;
                if (y == r) {
                    y = 0;
                    x++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ReshapetheMatrix rsm = new ReshapetheMatrix();
        int[][] mat = new int[][]{{1, 2, 3, 4}};
        System.out.println(Arrays.deepToString(rsm.matrixReshape(mat, 2, 2)));
    }
}
