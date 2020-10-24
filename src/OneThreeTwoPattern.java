
import java.util.Stack;

public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < min.length; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == min[i]) {
                continue;
            } else if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else if (stack.peek() > nums[i]) {
                stack.push(nums[i]);
            } else if (nums[i] > stack.peek()) {
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(nums[i]);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        OneThreeTwoPattern ottp = new OneThreeTwoPattern();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(ottp.find132pattern(nums));
    }
}
