
import java.util.Arrays;

public class UncrossedLines {

    private int[][] dp;

    public int maxUncrossedLines(int[] A, int[] B) {
        this.dp = new int[A.length][B.length];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(A, B, A.length - 1, B.length - 1);
    }

    private int helper(int[] A, int[] B, int i, int j) {
        if (i == 0 && j == 0) {
            if (A[i] == B[j]) {
                return 1;
            } else {
                return 0;
            }
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        int ans = 0;
        if (A[i] == B[j]) {
            ans = 1 + helper(A, B, i - 1, j - 1);
        } else {
            ans = Math.max(helper(A, B, i - 1, j), helper(A, B, i, j - 1));
        }
        return this.dp[i][j] = ans;
    }

    public static void main(String args[]) {
        UncrossedLines ul = new UncrossedLines();
        int[] A = new int[]{2, 5, 1, 2, 5};
        int[] B = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(ul.maxUncrossedLines(A, B));
    }
}
