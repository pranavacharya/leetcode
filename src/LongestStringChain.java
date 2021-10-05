
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        int longest = 0;
        HashSet<String> set = new HashSet();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 1));
            ArrayList<String> seq = remChar(words[i]);
            for (int j = 0; j < seq.size(); j++) {
                if (map.containsKey(seq.get(j))) {
                    map.put(words[i], Math.max(map.get(words[i]), map.get(seq.get(j)) + 1));
                }
            }
            longest = Math.max(longest, map.get(words[i]));
        }
        return longest;
    }

    private ArrayList<String> remChar(String s) {
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i) + s.substring(i + 1);
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        LongestStringChain lsc = new LongestStringChain();
        String[] words = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(lsc.longestStrChain(words));
    }
}
