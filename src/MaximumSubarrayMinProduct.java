
import java.util.Stack;

public class MaximumSubarrayMinProduct {

    int mod = (int) 1e9 + 7;

    public int maxSumMinProduct(int[] nums) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = nums.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        long maxMinProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            long sum = prefix[right[i]] - prefix[left[i] + 1];
            long product = min * sum;
            maxMinProduct = Math.max(maxMinProduct, product);
        }
        return (int) (maxMinProduct % mod);
    }

    public static void main(String[] args) {
        MaximumSubarrayMinProduct msmp = new MaximumSubarrayMinProduct();
        int[] nums = new int[]{2, 3, 3, 1, 2};
        System.out.println(msmp.maxSumMinProduct(nums));
    }
}
