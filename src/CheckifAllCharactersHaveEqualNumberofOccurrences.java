
import java.util.HashMap;
import java.util.HashSet;

public class CheckifAllCharactersHaveEqualNumberofOccurrences {

    public boolean areOccurrencesEqual(String s) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i) - 'a', freq.getOrDefault(s.charAt(i) - 'a', 0) + 1);
        }
        HashSet<Integer> set = new HashSet();
        for (int key : freq.keySet()) {
            set.add(freq.get(key));
        }
        return set.size() == 1;
    }

    public static void main(String[] args) {
        CheckifAllCharactersHaveEqualNumberofOccurrences ciacheno = new CheckifAllCharactersHaveEqualNumberofOccurrences();
        System.out.println(ciacheno.areOccurrencesEqual("abacbc"));
    }
}
