
import java.util.Arrays;

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = swap(A[i]);
            A[i] = inverse(A[i]);
        }
        return A;
    }

    public int[] swap(int[] A) {
        for (int i = 0; i < A.length / 2; i++) {
            int temp = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = temp;
        }
        return A;
    }

    public int[] inverse(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[i] = 1;
            } else {
                A[i] = 0;
            }
        }
        return A;
    }

    public static void main(String args[]) {
        FlippingAnImage fi = new FlippingAnImage();
//        int[][] A = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(fi.flipAndInvertImage(A)));
    }
}
