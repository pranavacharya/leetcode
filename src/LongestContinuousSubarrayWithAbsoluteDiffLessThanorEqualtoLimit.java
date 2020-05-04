
import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {

    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Deque<Integer> max = new LinkedList();
        Deque<Integer> min = new LinkedList();

        int maxLength = 0;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            while (!max.isEmpty() && nums[max.peekLast()] < nums[end]) {
                max.pollLast();
            }
            while (!min.isEmpty() && nums[min.peekLast()] > nums[end]) {
                min.pollLast();
            }
            max.addLast(end);
            min.addLast(end);

            if (Math.abs(nums[max.peek()] - nums[min.peek()]) <= limit) {
                maxLength = Math.max(maxLength, end - start + 1);
            } else {
                if (nums[max.peek()] == nums[start]) {
                    max.pollFirst();
                } else if (nums[min.peek()] == nums[start]) {
                    min.pollFirst();
                }
                start++;
            }
            end++;
        }
        return maxLength;
    }

    public static void main(String args[]) {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit lcswadltoetl = new LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit();
        int[] nums = new int[]{10, 1, 2, 4, 7, 2};
        System.out.println(lcswadltoetl.longestSubarray(nums, 5));
    }
}
