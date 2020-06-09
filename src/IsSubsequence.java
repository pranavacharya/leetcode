
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            while (i < s.length() && j < t.length() && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            if (j == t.length() && i < s.length()) {
                return false;
            }
            i++;
            j++;
        }
        return i == s.length();
    }

    public static void main(String args[]) {
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence("axc", "ahbgdc"));
    }
}
