
import java.util.Arrays;

public class FindValidMatrixGivenRowandColumnSums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }

    public static void main(String args[]) {
        FindValidMatrixGivenRowandColumnSums fvmgwc = new FindValidMatrixGivenRowandColumnSums();
        int[] rowSum = new int[]{5, 7, 10};
        int[] colSum = new int[]{8, 6, 8};
        System.out.println(Arrays.deepToString(fvmgwc.restoreMatrix(rowSum, colSum)));
    }
}
