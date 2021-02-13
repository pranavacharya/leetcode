
import java.util.Arrays;

public class ImageSmoother {

    private int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public int[][] imageSmoother(int[][] M) {

        int[][] ans = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int val = M[i][j];
                int total = 1;
                for (int[] dir : dirs) {
                    if (i + dir[0] < M.length && i + dir[0] >= 0 && j + dir[1] < M[i].length && j + dir[1] >= 0) {
                        val += M[i + dir[0]][j + dir[1]];
                        total++;
                    }
                }
                ans[i][j] = val / total;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        ImageSmoother is = new ImageSmoother();
        int[][] M = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(is.imageSmoother(M)));
    }
}
