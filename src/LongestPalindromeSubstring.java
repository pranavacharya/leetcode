
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {

        String max = "";
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    max = max.length() > j - i ? max : s.substring(i, j);
                }
            }
        }
        return max;
    }

    public boolean isPalindrome(String input) {
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}
