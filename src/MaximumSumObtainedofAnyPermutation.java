
import java.util.PriorityQueue;

public class MaximumSumObtainedofAnyPermutation {

    private int mod = 1000000007;

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] da = new int[nums.length + 1];
        for (int[] req : requests) {
            int start = req[0];
            int end = req[1];
            da[start]++;
            da[end + 1]--;
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = da[i];
            } else {
                arr[i] = da[i] + arr[i - 1];
            }
        }
        PriorityQueue<Integer> numsQueue = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : nums) {
            numsQueue.add(num);
        }
        PriorityQueue<Integer> indexQueue = new PriorityQueue<>((a, b) -> (b - a));
        for (int index : arr) {
            indexQueue.add(index);
        }
        int sum = 0;
        while (!indexQueue.isEmpty() && !numsQueue.isEmpty()) {
            int ans = indexQueue.poll() * numsQueue.poll();
            sum = ((sum % mod) + (ans % mod)) % mod;
        }
        return sum;
    }

    public static void main(String args[]) {
        MaximumSumObtainedofAnyPermutation msoap = new MaximumSumObtainedofAnyPermutation();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[][] requests = new int[][]{{1, 3}, {0, 1}};
        System.out.println(msoap.maxSumRangeQuery(nums, requests));
    }
}
