
import java.util.HashMap;

public class SubstringsofSizeThreewithDistinctCharacters {

    public int countGoodSubstrings(String s) {
        int start = 0;
        int end = 0;
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap();
        while (end < s.length()) {
            if (end - start < 3) {
                freq.put(s.charAt(end) - 'a', freq.getOrDefault(s.charAt(end) - 'a', 0) + 1);
                end++;
            } else {
                freq.put(s.charAt(start) - 'a', freq.get(s.charAt(start) - 'a') - 1);
                if (freq.get(s.charAt(start) - 'a') == 0) {
                    freq.remove(s.charAt(start) - 'a');
                }
                start++;
            }
            if (freq.size() == 3) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubstringsofSizeThreewithDistinctCharacters sostwdc = new SubstringsofSizeThreewithDistinctCharacters();
        System.out.println(sostwdc.countGoodSubstrings("aababcabc"));
    }
}
