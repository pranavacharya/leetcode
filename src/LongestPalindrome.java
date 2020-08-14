
import java.util.HashMap;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        boolean odd = false;
        for (int val : freq.values()) {
            if (val % 2 == 0) {
                length += val;
            } else {
                odd = true;
                length += (val - 1);
            }
        }
        if (odd) {
            length++;
        }
        return length;
    }

    public static void main(String args[]) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("abccccdd"));
    }
}
