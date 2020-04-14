
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && !seen.contains(s.charAt(j))) {
                seen.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, j - i);
            seen.clear();
        }
        return max;
    }

    public static void main(String args[]) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lswrc.lengthOfLongestSubstring("abcabcbb"));
    }
}
