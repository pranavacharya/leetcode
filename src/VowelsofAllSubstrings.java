
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
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                long vowels = prefix[j + 1] - prefix[i];
                ans += vowels;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        VowelsofAllSubstrings vas = new VowelsofAllSubstrings();
        System.out.println(vas.countVowels("aba"));
    }
}
