
import java.util.Arrays;
import java.util.HashSet;

public class FrogJump {

    private int[][] dp;

    public boolean canCross(int[] stones) {
        int lastStone = stones[stones.length - 1];
        this.dp = new int[stones.length + 1][stones.length + 1];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < stones.length; i++) {
            set.add(stones[i]);
        }
        return helper(stones[0], 1, set, true, stones) == 1;
    }

    private long helper(int i, int k, HashSet<Integer> set, boolean isFirst, int[] stones) {
        if (k < 0) {
            return 0;
        }

        if (!set.contains(i)) {
            return 0;
        }

        int index = Arrays.binarySearch(stones, i);

        if (index == stones.length - 1) {
            return 1;
        }

        if (this.dp[index][k] != -1) {
            return this.dp[index][k];
        }

        if (helper(stones[index] + k, k, set, false, stones) == 1) {
            return this.dp[index][k] = 1;
        }
        if (!isFirst && helper(stones[index] + k + 1, k + 1, set, false, stones) == 1) {
            return this.dp[index][k] = 1;
        }

        if (k != 1 && !isFirst && helper(stones[index] + k - 1, k - 1, set, false, stones) == 1) {
            return this.dp[index][k] = 1;
        }

        return this.dp[index][k] = 0;
    }

    public static void main(String[] args) {
        FrogJump fj = new FrogJump();
//        int[] stones = new int[]{0, 1, 2, 3, 4, 8, 9, 11};
        int[] stones = new int[]{0, 1, 3, 6, 10, 13, 15, 18};
        System.out.println(fj.canCross(stones));
    }
}
