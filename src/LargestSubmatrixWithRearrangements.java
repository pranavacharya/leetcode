
import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] height = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[i].length; j++) {
                if (matrix[i][j] == 0) {
                    height[i][j] = 0;
                } else {
                    if (i == 0) {
                        height[i][j] = 1;
                    } else {
                        height[i][j] = height[i - 1][j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            Arrays.sort(height[i]);
            for (int j = height[i].length - 1; j >= 0; j--) {
                int area = height[i][j] * (height[i].length - j);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LargestSubmatrixWithRearrangements lsmr = new LargestSubmatrixWithRearrangements();
        int[][] matrix = new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println(lsmr.largestSubmatrix(matrix));
    }
}
