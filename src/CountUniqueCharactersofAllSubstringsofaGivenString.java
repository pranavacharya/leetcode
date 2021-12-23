
public class CountUniqueCharactersofAllSubstringsofaGivenString {

    public int uniqueLetterString(String s) {
        int ans = 0;
        int[] last = new int[26];
        int[] dp = new int[26];
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curr -= dp[c - 'A'];
            dp[c - 'A'] = i - (last[c - 'A'] - 1);
            curr += dp[c - 'A'];
            last[c - 'A'] = i + 1;
            ans += curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountUniqueCharactersofAllSubstringsofaGivenString cucasgs = new CountUniqueCharactersofAllSubstringsofaGivenString();
        System.out.println(cucasgs.uniqueLetterString("LEETCODE"));
    }
}
