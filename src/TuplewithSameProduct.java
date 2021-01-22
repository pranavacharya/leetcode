
import java.util.HashMap;

public class TuplewithSameProduct {

    public int tupleSameProduct(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > 1) {
                long combination = (factorial(freq) / (factorial(freq - 2) * 2));
                count += (8 * combination);
            }
        }
        return count;
    }

    private long factorial(int a) {
        long ans = 1;
        for (int i = a; i > 0; i--) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String args[]) {
        TuplewithSameProduct twsp = new TuplewithSameProduct();
        int[] nums = new int[]{2, 3, 4, 6};
        System.out.println(twsp.tupleSameProduct(nums));
    }
}
