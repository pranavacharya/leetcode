
import java.util.Arrays;

public class FlippinganImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int len = A[i].length;
            int half = len % 2 == 0 ? len / 2 : len / 2 + 1;
            for (int j = 0; j < half; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - 1 - j] == 1 ? 0 : 1;
                A[i][A[i].length - 1 - j] = temp == 1 ? 0 : 1;
            }
        }
        return A;
    }

    public static void main(String args[]) {
        FlippingAnImage fi = new FlippingAnImage();
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(fi.flipAndInvertImage(A)));
    }
}
