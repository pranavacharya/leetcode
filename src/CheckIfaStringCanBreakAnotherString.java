
import java.util.HashSet;

public class CheckIfaStringCanBreakAnotherString {

    private HashSet<String> permutation;

    public CheckIfaStringCanBreakAnotherString() {
        permutation = new HashSet();
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        permute(s1, "");
        return permuteAndCheck(s2, "");
    }

    public void permute(String rem, String soFar) {
        if (rem.length() == 0) {
            this.permutation.add(soFar);
        } else {
            for (int i = 0; i < rem.length(); i++) {
                char letter = rem.charAt(i);
                String before = rem.substring(0, i);
                String after = rem.substring(i + 1);
                permute(before.concat(after), soFar.concat("" + letter));
            }
        }
    }

    public boolean permuteAndCheck(String rem, String soFar) {
        if (rem.length() == 0) {
            for (String key : permutation) {
                if (checkIfBreak(key, soFar)) {
                    System.out.println(soFar);
                    System.out.println(key);
                    return true;
                }
            }
            return false;
        } else {
            boolean status = false;
            for (int i = 0; i < rem.length(); i++) {
                char letter = rem.charAt(i);
                String before = rem.substring(0, i);
                String after = rem.substring(i + 1);
                status = status || permuteAndCheck(before.concat(after), soFar.concat("" + letter));
            }
            return status;
        }
    }

    public boolean checkIfBreak(String s1, String s2) {
        boolean b1 = true, b2 = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                b1 = false;
                break;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) < s1.charAt(i)) {
                b2 = false;
                break;
            }
        }
        return b1 || b2;
    }

    public static void main(String args[]) {
        CheckIfaStringCanBreakAnotherString ciscbas = new CheckIfaStringCanBreakAnotherString();
        System.out.println(ciscbas.checkIfCanBreak("abc", "xya"));
    }
}
