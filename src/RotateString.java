
public class RotateString {

    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        int i = 0;
        while (i < B.length()) {
            while (i < B.length() && B.charAt(i) != A.charAt(0)) {
                i++;
            }
            if (A.equals(B.substring(i).concat(B.substring(0, i)))) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String args[]) {
        RotateString rs = new RotateString();
        System.out.println(rs.rotateString("abcde", "cdeab"));
    }
}
