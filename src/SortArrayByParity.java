
import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int index = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                ans[index++] = a;
            }
        }
        for (int a : A) {
            if (a % 2 != 0) {
                ans[index++] = a;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        SortArrayByParity sabp = new SortArrayByParity();
        int[] A = new int[]{3363, 4833, 290, 3381, 4227, 1711, 1253, 2984, 2212, 874, 2358, 2049, 2846, 2543, 1557, 1786, 4189, 1254, 2803, 62, 3708, 1679, 228, 1404, 1200, 4766, 1761, 1439, 1796, 4735, 3169, 3106, 3578, 1940, 2072, 3254, 7, 961, 1672, 1197, 3187, 1893, 4377, 2841, 2072, 2011, 3509, 2091, 3311, 233};
        System.out.println(Arrays.toString(sabp.sortArrayByParity(A)));
    }
}
