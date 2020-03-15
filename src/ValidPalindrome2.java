
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int index = 0;
        while (index < s.length()) {
            String temp = s.substring(0, index).concat(s.substring(index + 1));
            if (isPalindrome(temp)) {
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (arr[i] != arr[s.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ValidPalindrome2 vp2 = new ValidPalindrome2();
        System.out.println(vp2.validPalindrome("abca"));
    }
}
