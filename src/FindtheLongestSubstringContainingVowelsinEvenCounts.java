
import java.util.Arrays;

public class FindtheLongestSubstringContainingVowelsinEvenCounts {

    public int findTheLongestSubstring(String s) {
        char[] set = {1, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0};
        int[] pos = new int[32];
        int ans = 0;
        int mask = 0;
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            mask ^= set[index];
            if (mask != 0 && pos[mask] == -1) {
                pos[mask] = i;
            }
            ans = Math.max(ans, i - pos[mask]);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindtheLongestSubstringContainingVowelsinEvenCounts flscvec
                = new FindtheLongestSubstringContainingVowelsinEvenCounts();
        System.out.println(flscvec.findTheLongestSubstring("eleetminicoworoep"));
    }
}
