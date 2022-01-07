
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 0;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ValidPalindrome2 vp2 = new ValidPalindrome2();
        System.out.println(vp2.validPalindrome("acbca"));
    }
}
