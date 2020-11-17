
import java.util.HashMap;

public class DetermineifTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        HashMap<Integer, Integer> value1 = new HashMap();
        HashMap<Integer, Integer> value2 = new HashMap();
        for (int i = 0; i < freq1.length; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
            value1.put(freq1[i], value1.getOrDefault(freq1[i], 0) + 1);
            value2.put(freq2[i], value2.getOrDefault(freq2[i], 0) + 1);
        }

        for (int key : value1.keySet()) {
            if (value1.get(key) != value2.get(key)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        DetermineifTwoStringsAreClose dtsac = new DetermineifTwoStringsAreClose();
        System.out.println(dtsac.closeStrings("abc", "bca"));
        System.out.println(dtsac.closeStrings("a", "aa"));
        System.out.println(dtsac.closeStrings("cabbba", "abbccc"));
        System.out.println(dtsac.closeStrings("cabbba", "aabbss"));
    }
}
