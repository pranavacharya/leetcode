
import java.util.Arrays;

public class MinimumCosttoMergeStones {

    private int[][][] dp;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if (n == 1) {
            return 0;
        }
        while (n >= k) {
            n = (n - k + 1);
        }
        if (n != 1) {
            return -1;
        }
        this.dp = new int[stones.length][stones.length][k + 1];
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[i].length; j++) {
                Arrays.fill(this.dp[i][j], -1);
            }
        }
        int[] prefix = new int[stones.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + stones[i - 1];
        }
        return helper(stones, 0, stones.length - 1, 1, k, prefix);
    }

    private int helper(int[] stones, int i, int j, int piles, int k, int[] prefix) {
        if (this.dp[i][j][piles] != -1) {
            return this.dp[i][j][piles];
        }
        int min = Integer.MAX_VALUE;
        if (i == j) {
            min = piles == 1 ? 0 : min;
            return this.dp[i][j][piles] = min;
        }
        if (piles == 1) {
            int mergek = helper(stones, i, j, k, k, prefix);
            if (mergek != Integer.MAX_VALUE) {
                min = mergek + prefix[j + 1] - prefix[i];
            }
        } else {
            for (int l = i; l < j; l++) {
                int left = helper(stones, i, l, piles - 1, k, prefix);
                int right = helper(stones, l + 1, j, 1, k, prefix);
                if (left != Integer.MAX_VALUE && right != Integer.MAX_VALUE) {
                    min = Math.min(min, left + right);
                }
            }
        }
        return this.dp[i][j][piles] = min;
    }

    public static void main(String[] args) {
        MinimumCosttoMergeStones mcms = new MinimumCosttoMergeStones();
        int[] stones = new int[]{3, 2, 4, 1};
        System.out.println(mcms.mergeStones(stones, 2));
    }
}
