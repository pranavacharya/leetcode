
import java.util.Arrays;

public class CheckIfaStringCanBreakAnotherString {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        Arrays.sort(s1arr);
        Arrays.sort(s2arr);
        boolean b1 = true, b2 = true;
        for (int i = 0; i < s1arr.length; i++) {
            if (s1arr[i] < s2arr[i]) {
                b1 = false;
                break;
            }
        }
        for (int i = 0; i < s2arr.length; i++) {
            if (s2arr[i] < s1arr[i]) {
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
