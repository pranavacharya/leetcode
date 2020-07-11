
import java.util.PriorityQueue;

public class RangeSumofSortedSubarraySums {

    private int mod = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] prefix = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i + 1] = sum;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                minHeap.add(prefix[j] - prefix[i - 1]);
            }
        }
        int result = 0;
        right = right - left + 1;
        while (!minHeap.isEmpty() && left - 1 > 0) {
            minHeap.poll();
            left--;
        }
        while (!minHeap.isEmpty() && right > 0) {
            result = ((result % mod) + (minHeap.poll() % mod)) % mod;
            right--;
        }

        return result;
    }

    public static void main(String args[]) {
        RangeSumofSortedSubarraySums rsosss = new RangeSumofSortedSubarraySums();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(rsosss.rangeSum(nums, 4, 1, 5));
    }
}
