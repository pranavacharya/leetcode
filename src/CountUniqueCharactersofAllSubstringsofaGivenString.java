
public class CountUniqueCharactersofAllSubstringsofaGivenString {

    boolean dp[][];

    public int uniqueLetterString(String s) {
        int[][] freq = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int k = 0; k < 26; k++) {
                freq[i + 1][k] = freq[i][k];
            }
            freq[i + 1][c - 'A'] = freq[i][c - 'A'] + 1;
        }
        this.dp = new boolean[s.length() + 1][s.length() + 1];
        // System.out.println(Arrays.deepToString(freq));
        return helper(s, 0, s.length() - 1, freq);
    }

    private int helper(String s, int i, int j, int[][] freq) {
        if (dp[i][j]) {
            return 0;
        }
        int sum = 0;

        for (int k = 0; k < 26; k++) {
            if (freq[j + 1][k] - freq[i][k] == 1) {
                sum++;
            }
        }

        for (int k = i; k < j; k++) {
            sum += helper(s, i, k, freq);
            sum += helper(s, k + 1, j, freq);
        }
        dp[i][j] = true;
        return sum;
    }

    public static void main(String[] args) {
        CountUniqueCharactersofAllSubstringsofaGivenString cucasgs = new CountUniqueCharactersofAllSubstringsofaGivenString();
        System.out.println(cucasgs.uniqueLetterString("ABC"));
    }
}
