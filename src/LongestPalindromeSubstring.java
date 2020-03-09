
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i <= s.length(); i++) {
            String temp, temp1, temp2;
            temp1 = moveFromCenter(s, i);
            temp2 = moveFromCenter2(s, i);
            temp = temp1.length() > temp2.length() ? temp1 : temp2;
            max = max.length() > temp.length() ? max : temp;
        }
        return max;
    }

    public String moveFromCenter(String ip, int k) {
        String ans = "";
        int left = k;
        int right = k;
        while (left >= 0 && right < ip.length()) {
            if (ip.charAt(left) == ip.charAt(right)) {
                ans = ip.substring(left, right + 1);
                left--;
                right++;
            } else {
                break;
            }
        }
        return ans;
    }

    public String moveFromCenter2(String ip, int k) {
        String ans = "";
        int left = k;
        int right = k + 1;
        while (left >= 0 && right < ip.length()) {
            if (ip.charAt(left) == ip.charAt(right)) {
                ans = ip.substring(left, right + 1);
                left--;
                right++;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}
