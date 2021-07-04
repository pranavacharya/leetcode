
import java.util.Arrays;

public class CountVowelsPermutation {
    private int mod = (int) 1e9 + 7;
    private int[][] dp;

    public int countVowelPermutation(int n) {
        this.dp = new int[n + 1][26];
        for(int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        int ans = 0;
        ans = (ans % mod + helper(1, n, 'a') % mod) % mod;
        ans = (ans % mod + helper(1, n, 'e') % mod) % mod;
        ans = (ans % mod + helper(1, n, 'i') % mod) % mod;
        ans = (ans % mod + helper(1, n, 'o') % mod) % mod;
        ans = (ans % mod + helper(1, n, 'u') % mod) % mod;
        return ans;
    }

    private int helper(int i, int n, char c) {
        if (i == n) {
            return 1;
        }
        if(this.dp[i][c - 'a'] != -1) {
            return this.dp[i][c - 'a'];
        }
        int ans = 0;
        switch(c) {
            case 'a':
                ans = (ans % mod + helper(i + 1, n, 'e') % mod) % mod;
                break;
            case 'e':
                ans = (ans % mod + helper(i + 1, n, 'a') % mod) % mod;
                ans = (ans % mod + helper(i + 1, n, 'i') % mod) % mod;
                break;
            case 'i':
                ans = (ans % mod + helper(i + 1, n, 'a') % mod) % mod;
                ans = (ans % mod + helper(i + 1, n, 'e') % mod) % mod;
                ans = (ans % mod + helper(i + 1, n, 'o') % mod) % mod;
                ans = (ans % mod + helper(i + 1, n, 'u') % mod) % mod;
                break;
            case 'o':
                ans = (ans % mod + helper(i + 1, n, 'i') % mod) % mod;
                ans = (ans % mod + helper(i + 1, n, 'u') % mod) % mod;
                break;
            case 'u':
                ans = (ans % mod + helper(i + 1, n, 'a') % mod) % mod;
                break;
            default:
                break;
        }
        return this.dp[i][c - 'a'] = ans;
    }

    public static void main(String args[]) {
        CountVowelsPermutation cvp  = new CountVowelsPermutation();
        System.out.println(cvp.countVowelPermutation(5));
    }
}
