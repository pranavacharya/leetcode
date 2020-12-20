
import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque();
        int[] dp = new int[n];
        dp[0] = nums[0];
        deque.addLast(0);
        for (int i = 1; i < dp.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.removeFirst();
            }
            dp[i] = nums[i] + dp[deque.peekFirst()];
            while (!deque.isEmpty() && dp[deque.peekLast()] < dp[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return dp[n - 1];
    }

    public static void main(String args[]) {
        JumpGameVI jg = new JumpGameVI();
        int[] nums = new int[]{1, -5, -20, 4, -1, 3, -6, -3};
        System.out.println(jg.maxResult(nums, 2));
    }

}
