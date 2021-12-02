
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = expandFromMiddle(s, i);
            String str2 = expandFromMiddle2(s, i);
            if (str1.length() > ans.length()) {
                ans = str1;
            }

            if (str2.length() > ans.length()) {
                ans = str2;
            }
        }
        return ans;
    }

    private String expandFromMiddle(String s, int index) {
        int left = index;
        int right = index;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    private String expandFromMiddle2(String s, int index) {
        int left = index;
        int right = index + 1;
        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
            return "";
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}
