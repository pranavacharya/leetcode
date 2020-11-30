
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FindtheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else if (stack.peek() <= nums[i]) {
                stack.push(nums[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > nums[i] && (nums.length - i - 1 + stack.size() >= k)) {
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        while (!stack.isEmpty() && stack.size() != k) {
            stack.pop();
        }
        ArrayList<Integer> list = new ArrayList(stack);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String args[]) {
        FindtheMostCompetitiveSubsequence fmcs = new FindtheMostCompetitiveSubsequence();
        int[] nums = new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2};
        System.out.println(Arrays.toString(fmcs.mostCompetitive(nums, 3)));
    }
}
