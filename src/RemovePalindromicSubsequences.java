
public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RemovePalindromicSubsequences rps = new RemovePalindromicSubsequences();
        System.out.println(rps.removePalindromeSub("baabb"));
    }
}
