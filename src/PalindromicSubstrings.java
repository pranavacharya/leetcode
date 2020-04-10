
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    max++;
                }
            }
        }
        return max;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("aaa"));
    }
}
