
import java.util.Arrays;
import java.util.HashMap;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int i = 0;
        int j = 1;
        for (int key : map.keySet()) {
            int count = map.get(key);
            for (int k = 0; k < count; k++) {
                if (key % 2 == 0) {
                    ans[i] = key;
                    i += 2;
                } else {
                    ans[j] = key;
                    j += 2;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        SortArrayByParityII asp = new SortArrayByParityII();
        int[] A = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(asp.sortArrayByParityII(A)));
    }
}
