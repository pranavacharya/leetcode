
import java.util.Arrays;

public class SquaresofaSortedArray {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {

            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String args[]) {
        SquaresofaSortedArray ssa = new SquaresofaSortedArray();
        int[] A = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(ssa.sortedSquares(A)));
    }
}
