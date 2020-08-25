
import java.util.Arrays;

public class SquaresofaSortedArray {

    public int[] sortedSquares(int[] A) {
        int i = 0;
        while (i < A.length && A[i] < 0) {
            i++;
        }
        int j;
        if (i >= 1) {
            j = i - 1;
        } else {
            j = -1;
        }
        int[] res = new int[A.length];
        int index = 0;
        while (i < A.length && j >= 0) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[index++] = A[j] * A[j];
                j--;
            } else {
                res[index++] = A[i] * A[i];
                i++;
            }
        }
        while (i < A.length) {
            res[index++] = A[i] * A[i];
            i++;
        }
        while (j >= 0) {
            res[index++] = A[j] * A[j];
            j--;
        }
        return res;
    }

    public static void main(String args[]) {
        SquaresofaSortedArray ssa = new SquaresofaSortedArray();
//        int[] A = new int[]{1};
        int[] A = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(ssa.sortedSquares(A)));
    }
}
