
import java.util.Arrays;

public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        int transpose[][] = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }

    public static void main(String args[]) {
        TransposeMatrix tm = new TransposeMatrix();
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(tm.transpose(A)));
    }
}
