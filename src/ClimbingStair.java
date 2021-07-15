
public class ClimbingStair {

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String args[]) {
        ClimbingStair cs = new ClimbingStair();
        System.out.println(cs.climbStairs(44));
        System.out.println(cs.climbStairs(3));
    }
}
