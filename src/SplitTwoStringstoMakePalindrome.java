
public class SplitTwoStringstoMakePalindrome {

    public boolean checkPalindromeFormation(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            String first = a.substring(0, i) + b.substring(i);
            String second = b.substring(0, i) + a.substring(i);
            if (checkIfPalindrom(first) || checkIfPalindrom(second)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        SplitTwoStringstoMakePalindrome stsmp = new SplitTwoStringstoMakePalindrome();
        System.out.println(stsmp.checkPalindromeFormation("x", "y"));
    }
}
