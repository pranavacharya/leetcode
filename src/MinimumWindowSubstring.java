
import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freqt = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            freqt.put(t.charAt(i), freqt.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> freq = new HashMap();
        String ans = s + "a";
        int i = 0;
        int j = 0;
        int total = freqt.size();
        int unique = 0;
        while (j < s.length()) {

            //expand
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

            if (freqt.containsKey(s.charAt(j))
                    && freq.get(s.charAt(j)).intValue() == freqt.get(s.charAt(j)).intValue()) {
                unique++;
            }

            //contract
            while (i <= j && unique == total) {
                String local = s.substring(i, j + 1);
                if (local.length() < ans.length()) {
                    ans = local;
                }
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                if (freqt.containsKey(s.charAt(i))
                        && freq.get(s.charAt(i)).intValue() < freqt.get(s.charAt(i)).intValue()) {
                    unique--;
                }
                i++;
            }
            j++;
        }
        return ans.length() > s.length() ? "" : ans;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
    }
}
