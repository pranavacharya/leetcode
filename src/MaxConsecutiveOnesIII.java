
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int ans = 0;
        int K = k;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else {
                if (k > 0) {
                    k--;
                    end++;
                } else {
                    if (nums[start] == 0) {
                        k++;
                    }
                    start++;
                }
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII mco = new MaxConsecutiveOnesIII();
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(mco.longestOnes(nums, 2));
    }
}
