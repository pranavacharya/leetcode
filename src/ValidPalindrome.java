
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j && !((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= '0' && arr[i] <= '9'))) {
                i++;
            }
            while (i < j && !((arr[j] >= 'A' && arr[j] <= 'Z') || (arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= '0' && arr[j] <= '9'))) {
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
