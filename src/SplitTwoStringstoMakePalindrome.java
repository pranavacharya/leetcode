
public class SplitTwoStringstoMakePalindrome {

    public boolean checkPalindromeFormation(String a, String b) {
        return checkCombination(a, b) || checkCombination(b, a);
    }

    private boolean checkCombination(String a, String b) {
        int i = 0;
        int j = a.length() - 1;
        while (i <= j) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return (checkIfPalindrom(a, i, j) || checkIfPalindrom(b, i, j));
    }

    public boolean checkIfPalindrom(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        SplitTwoStringstoMakePalindrome stsmp = new SplitTwoStringstoMakePalindrome();
        System.out.println(stsmp.checkPalindromeFormation("ulacfd", "jizalu"));
    }
}
