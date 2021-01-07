
public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        int ans = 0;
        int[] dp = new int[arr.length];
        if (arr.length < 2) {
            return arr.length;
        }
        if (arr.length == 2) {
            return arr[0] == arr[1] ? 1 : 2;
        }
        dp[0] = 1;
        dp[1] = arr[0] == arr[1] ? 1 : 2;
        for (int i = 2; i < dp.length; i++) {
            if ((arr[i] > arr[i - 1] && arr[i - 1] < arr[i - 2])
                    || (arr[i] < arr[i - 1] && arr[i - 1] > arr[i - 2])) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = arr[i] == arr[i - 1] ? 1 : 2;
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String args[]) {
        LongestTurbulentSubarray lts = new LongestTurbulentSubarray();
        int[] arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(lts.maxTurbulenceSize(arr));
    }
}
