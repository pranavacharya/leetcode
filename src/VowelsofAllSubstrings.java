
import java.util.HashSet;

public class VowelsofAllSubstrings {

    public long countVowels(String word) {
        long[] prefix = new long[word.length() + 1];
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        long count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.charAt(i))) {
                count++;
            }
            prefix[i + 1] = count;
        }
        long ans = 0;
        int times = 1;
        int timesLess = word.length() - 1;
        for (int i = 1; i < prefix.length; i++) {
            ans += (prefix[i] * times - prefix[i] * timesLess);
            times++;
            timesLess--;
        }
        return ans;
    }

    public static void main(String[] args) {
        VowelsofAllSubstrings vas = new VowelsofAllSubstrings();
        System.out.println(vas.countVowels("aba"));
    }
}
