
public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int longest = 1;
        int[][] dp = new int[arr.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
            } else if (arr[i] < arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            longest = Math.max(longest, Math.max(dp[i][0], dp[i][1]));
        }
        return longest;
    }

    public static void main(String args[]) {
        LongestTurbulentSubarray lts = new LongestTurbulentSubarray();
        int[] arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(lts.maxTurbulenceSize(arr));
    }
}
