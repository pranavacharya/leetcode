
import java.util.Arrays;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }

                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

        return A;
    }

    public static void main(String args[]) {
        SortArrayByParityII asp = new SortArrayByParityII();
        int[] A = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(asp.sortArrayByParityII(A)));
    }
}
