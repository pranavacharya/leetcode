
import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public List<Integer> pancakeSort(int[] A) {
        ArrayList<Integer> result = new ArrayList();
        int n = A.length;
        while (n > 1) {
            int index = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == n) {
                    index = i;
                    break;
                }
            }
            if (index != 0) {
                result.add(index + 1);
                flip(0, index, A);
            }
            result.add(n);
            flip(0, n - 1, A);
            n--;
        }
        return result;
    }

    public void flip(int start, int end, int[] arr) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        PancakeSorting ps = new PancakeSorting();
        int[] A = new int[]{3, 2, 4, 1};
        System.out.println(ps.pancakeSort(A));
    }
}
