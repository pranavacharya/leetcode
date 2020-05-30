
import java.util.HashSet;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet();
        for (int i = k; i <= s.length(); i++) {
            set.add(s.substring(i - k, i));
        }
        return set.size() == 1 << k;
    }

    public static void main(String args[]) {
        CheckIfaStringContainsAllBinaryCodesofSizeK ciscabcsk = new CheckIfaStringContainsAllBinaryCodesofSizeK();
        System.out.println(ciscabcsk.hasAllCodes("00110110", 2));
    }
}
