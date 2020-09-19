
public class MakeSumDivisiblebyP {

    public int minSubarray(int[] nums, int p) {
        long[] prefixSum = new long[nums.length + 1];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            prefixSum[i + 1] = sum;
        }
        if (prefixSum[prefixSum.length - 1] % p == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isRestDivisble(prefixSum, i, j, p)) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        if (min == nums.length) {
            min = -1;
        }
        return min;
    }

    private boolean isRestDivisble(long[] prefixSum, int start, int end, int p) {
        long sumBegin = prefixSum[start];
        long sumEnd = prefixSum[prefixSum.length - 1] - prefixSum[end + 1];
        return (sumBegin + sumEnd) % p == 0;
    }

    public static void main(String args[]) {
        MakeSumDivisiblebyP msdp = new MakeSumDivisiblebyP();
        int[] nums = new int[]{3, 1, 4, 2};
        System.out.println(msdp.minSubarray(nums, 6));
    }
}
