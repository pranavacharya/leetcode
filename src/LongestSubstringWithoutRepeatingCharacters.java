
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                char st = s.charAt(start);
                set.remove(st);
                start++;
            } else {
                set.add(c);
                end++;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }

    public static void main(String args[]) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lswrc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lswrc.lengthOfLongestSubstring(""));
    }
}
