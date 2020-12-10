
import java.util.HashMap;

public class MaxNumberofKSumPairs {

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int ops = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ops++;
                int count = map.get(nums[i]);
                map.put(nums[i], count - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
            } else {
                map.put(k - nums[i], map.getOrDefault(k - nums[i], 0) + 1);
            }
        }
        return ops;
    }

    public static void main(String args[]) {
        MaxNumberofKSumPairs mnksp = new MaxNumberofKSumPairs();
        int[] nums = new int[]{3, 1, 3, 4, 3};
        System.out.println(mnksp.maxOperations(nums, 6));
    }
}
