
import java.util.Arrays;

public class JumpGameV {

    private int[] dp;

    public int maxJumps(int[] arr, int d) {

        this.dp = new int[arr.length];
        Arrays.fill(this.dp, -1);

        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, helper(arr, d, i));
        }
        return max;
    }

    private int helper(int[] arr, int d, int curr) {

        if (this.dp[curr] != -1) {
            return this.dp[curr];
        }

        int max = 0;
        // forward
        for (int i = curr + 1; i <= Math.min(arr.length - 1, curr + d); i++) {
            if (arr[i] < arr[curr]) {
                max = Math.max(max, helper(arr, d, i));
            } else {
                break;
            }
        }
        // backward
        for (int i = curr - 1; i >= Math.max(0, curr - d); i--) {
            if (arr[i] < arr[curr]) {
                max = Math.max(max, helper(arr, d, i));
            } else {
                break;
            }
        }
        return this.dp[curr] = max + 1;
    }

    public static void main(String[] args) {
        JumpGameV jg = new JumpGameV();
        int[] arr = new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        System.out.println(jg.maxJumps(arr, 2));
    }
}
