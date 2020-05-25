
import java.util.HashSet;

public class MaximumNumberofVowelsinaSubstringofGivenLength {

    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = s.length();
        int start = 0;
        int end = 0;
        int count = 0;
        int max = 0;
        while (end < n) {
            if (end - start + 1 <= k) {
                if (set.contains(s.charAt(end))) {
                    count++;
                    max = Math.max(max, count);
                }
                end++;
            } else {
                if (set.contains(s.charAt(start))) {
                    count--;
                }
                start++;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumNumberofVowelsinaSubstringofGivenLength mnvsgl = new MaximumNumberofVowelsinaSubstringofGivenLength();
        System.out.println(mnvsgl.maxVowels("abciiidef", 3));
        System.out.println(mnvsgl.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
    }
}
