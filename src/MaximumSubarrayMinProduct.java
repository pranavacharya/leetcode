
import java.util.PriorityQueue;

public class MaximumSubarrayMinProduct {

    int mod = (int) 1e9 + 7;

    public int maxSumMinProduct(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (nums[a] - nums[b]));

        long maxMinProduct = 0;
        for (int length = 1; length <= nums.length; length++) {
            minHeap.clear();
            for (int i = 0; i < nums.length; i++) {
                minHeap.add(i);
                while (!minHeap.isEmpty() && minHeap.peek() <= i - length) {
                    minHeap.poll();
                }
                int start = i - length + 1;
                int end = i;
                if (start >= 0) {
                    long sum = prefix[end + 1] - prefix[start];
                    long product = sum * nums[minHeap.peek()];
                    maxMinProduct = Math.max(maxMinProduct, product);
                }
            }
        }
        return (int) (maxMinProduct % mod);
    }

    public static void main(String[] args) {
        MaximumSubarrayMinProduct msmp = new MaximumSubarrayMinProduct();
        int[] nums = new int[]{2, 3, 3, 1, 2};
        System.out.println(msmp.maxSumMinProduct(nums));
    }
}
