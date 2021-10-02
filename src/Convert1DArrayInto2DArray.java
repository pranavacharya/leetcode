
import java.util.Arrays;

public class Convert1DArrayInto2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Convert1DArrayInto2DArray codttd = new Convert1DArrayInto2DArray();
        int[] original = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.deepToString(codttd.construct2DArray(original, 3, 2)));
    }
}
