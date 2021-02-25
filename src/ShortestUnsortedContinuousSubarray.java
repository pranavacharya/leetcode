
import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack();
        int start = nums.length, end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                start = Math.min(start, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }
        if (end < start) {
            return 0;
        } else {
            return end - start + 1;
        }
    }

    public static void main(String args[]) {
        ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(sucs.findUnsortedSubarray(nums));
    }
}
