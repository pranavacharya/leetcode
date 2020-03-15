
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        if (isPalindrome(s)) {
            return true;
        }
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                if (isPalindrome(s.substring(0, i).concat(s.substring(i + 1)))) {
                    return true;
                } else if (isPalindrome(s.substring(0, j).concat(s.substring(j + 1)))) {
                    return true;
                } else {
                    break;
                }
            }
            i++;
            j--;
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
        System.out.println(vp2.validPalindrome("acbca"));
    }
}
