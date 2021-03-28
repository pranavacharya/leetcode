
import java.util.HashSet;

public class NumberofDifferentIntegersinaString {

    public int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet();
        int i = 0;
        int j = 0;
        while (j < word.length()) {
            while (i < word.length()) {
                if (Character.isAlphabetic(word.charAt(i))) {
                    i++;
                } else {
                    break;
                }
            }
            j = i;
            while (j < word.length()) {
                if (Character.isDigit(word.charAt(j))) {
                    j++;
                } else {
                    break;
                }
            }
            if (i < word.length()) {
                int count = 0;
                for (int k = i; k < j; k++) {
                    if (word.charAt(k) == '0') {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count > 0) {
                    set.add(word.substring(i + count, j));
                } else {
                    set.add(word.substring(i, j));
                }
            }
            i = j + 1;
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        NumberofDifferentIntegersinaString ndis = new NumberofDifferentIntegersinaString();
        System.out.println(ndis.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(ndis.numDifferentIntegers("a1b01c001"));
        System.out.println(ndis.numDifferentIntegers("u"));
        System.out.println(ndis.numDifferentIntegers("0a0"));
    }
}
