
public class MaximumLengthofSubarrayWithPositiveProduct {

    public int getMaxLen(int[] nums) {
        int ans = 0;
        int last = -1;
        int first = -1;
        int start = -1;
        int neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                start = i;
                neg = 0;
                last = -1;
                first = -1;
                continue;
            }

            if (nums[i] < 0) {
                neg++;
                last = i;
                first = first == -1 ? i : first;
            }

            if (neg % 2 == 0) {
                ans = Math.max(ans, i - start);
            } else {
                ans = Math.max(ans, i - last);
                ans = Math.max(ans, i - first);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLengthofSubarrayWithPositiveProduct mlspp = new MaximumLengthofSubarrayWithPositiveProduct();
        int[] nums = new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2};
        System.out.println(mlspp.getMaxLen(nums));
    }
}
