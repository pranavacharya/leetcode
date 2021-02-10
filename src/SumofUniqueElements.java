
import java.util.HashMap;

public class SumofUniqueElements {

    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                sum += key;
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        SumofUniqueElements sue = new SumofUniqueElements();
        int[] nums = new int[]{1, 2, 3, 2};
        System.out.println(sue.sumOfUnique(nums));
    }
}
