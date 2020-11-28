
import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i + k <= nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            list.add(max);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String args[]) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(swm.maxSlidingWindow(nums, 3)));
    }
}
