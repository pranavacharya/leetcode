
import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {

    private int mod = (int) (1e9 + 7);

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Long> dp = new HashMap();
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] % arr[j] == 0) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.getOrDefault(arr[i] / arr[j], 0L) * dp.get(arr[j])) % mod);
                }
            }
            ans = (int) (((ans % mod) + (dp.get(arr[i]) % mod)) % mod);
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreesWithFactors btwf = new BinaryTreesWithFactors();
        int[] arr = new int[]{2, 4, 5, 10};
        System.out.println(btwf.numFactoredBinaryTrees(arr));
    }
}
