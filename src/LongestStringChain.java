
import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], 1);
        }
        int longest = 0;
        Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + word.substring(i + 1, word.length());
                if (map.containsKey(sub)) {
                    map.put(word, Math.max(map.get(word), map.get(sub) + 1));
                }
                longest = Math.max(longest, map.get(word));
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestStringChain lsc = new LongestStringChain();
        String[] words = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(lsc.longestStrChain(words));
    }
}
