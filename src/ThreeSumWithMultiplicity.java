
import java.util.HashMap;

public class ThreeSumWithMultiplicity {

    private int mod = (int) (1e9 + 7);

    public int threeSumMulti(int[] arr, int target) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int newTarget = target - arr[i];
            HashMap<Integer, Integer> freq = new HashMap();
            for (int j = i + 1; j < arr.length; j++) {
                if (freq.containsKey(arr[j])) {
                    ans = (ans % mod + freq.get(arr[j]) % mod) % mod;
                }
                freq.put(newTarget - arr[j], freq.getOrDefault(newTarget - arr[j], 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSumWithMultiplicity tsm = new ThreeSumWithMultiplicity();
        int[] arr = new int[]{1, 1, 2, 2, 2, 2};
        System.out.println(tsm.threeSumMulti(arr, 5));
    }
}
