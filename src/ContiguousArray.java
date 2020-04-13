
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = (nums[i] == 0) ? -1 : 1;
            } else {
                int val = (nums[i] == 0) ? -1 : 1;
                dp[i] = dp[i - 1] + val;
            }
            if (dp[i] == 0) {
                max = Math.max(max, i - 0 + 1);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            int val = dp[i - 1];
            for (int j = i; j < nums.length; j++) {
                dp[j] = dp[j] - val;
                if (dp[j] == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        ContiguousArray ca = new ContiguousArray();
        int[] nums = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
//        int[] nums = new int[]{0, 1};
        System.out.println(ca.findMaxLength(nums));
    }
}
