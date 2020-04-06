
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(arr[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(arr[j])) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("malayalam"));
    }
}
