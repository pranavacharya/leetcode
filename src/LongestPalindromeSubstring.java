
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = expandFromMiddle(s, i, i);
            String str2 = expandFromMiddle(s, i, i + 1);
            if (str1.length() > ans.length()) {
                ans = str1;
            }

            if (str2.length() > ans.length()) {
                ans = str2;
            }
        }
        return ans;
    }

    private String expandFromMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (left + 1 >= 0 && right - 1 < s.length()) {
            return s.substring(left + 1, right);
        }
        return "";
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}
