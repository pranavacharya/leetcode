
import java.util.Arrays;

public class UniqueLength3PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26];
        int last[] = new int[26];
        int res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ++i) {
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i) {
            if (first[i] < last[i]) {
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueLength3PalindromicSubsequences ulp = new UniqueLength3PalindromicSubsequences();
        System.out.println(ulp.countPalindromicSubsequence("bbcbaba"));
    }
}
