
import java.util.ArrayList;

public class LongestSubarrayof1AfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        ArrayList<Integer> list = new ArrayList();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (sum != 0) {
                    list.add(sum);
                }
                sum = 0;
                list.add(0);
            } else {
                sum = sum + nums[i];
            }
        }
        if (sum != 0) {
            list.add(sum);
        }
        System.out.println(list);
        int max = list.get(0) - 1;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) == 0) {
                max = Math.max(max, list.get(i - 1) + list.get(i + 1));
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestSubarrayof1AfterDeletingOneElement lso1ade = new LongestSubarrayof1AfterDeletingOneElement();
        int[] nums = new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(lso1ade.longestSubarray(nums));
    }
}
