
import java.util.Arrays;

public class JumpGameVII {

    private int dp[];

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }
        this.dp = new int[s.length()];
        Arrays.fill(this.dp, -1);
        return helper(s, 0, minJump, maxJump) == 1;
    }

    private int helper(String s, int index, int min, int max) {
        if (index == s.length() - 1) {
            return this.dp[index] = 1;
        }
        if (this.dp[index] != -1) {
            return this.dp[index];
        }
        for (int i = index + min; i <= Math.min(index + max, s.length() - 1); i++) {
            if (s.charAt(i) == '0' && helper(s, i, min, max) == 1) {
                return this.dp[index] = 1;
            }
        }
        return this.dp[index] = 0;
    }

    public static void main(String[] args) {
        JumpGameVII jg = new JumpGameVII();
        System.out.println(jg.canReach("011010", 2, 3));
    }
}
