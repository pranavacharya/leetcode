
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String pal = expandFromCenter(i, i, s);
            if (pal.length() > longest.length()) {
                longest = pal;
            }
            String pal2 = expandFromCenter(i, i + 1, s);
            if (pal2.length() > longest.length()) {
                longest = pal2;
            }
        }
        return longest;
    }

    private String expandFromCenter(int left, int right, String s) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}
