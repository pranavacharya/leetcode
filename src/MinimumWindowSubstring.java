
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
        while (j < s.length()) {

            //expand
            while (j < s.length()) {
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
                if (matchFreq(freq, freqt)) {
                    String local = s.substring(i, j + 1);
                    if (local.length() < ans.length()) {
                        ans = local;
                    }
                    break;
                }
                j++;
            }

            //contract
            while (i <= j) {
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                if (matchFreq(freq, freqt)) {
                    i++;
                    String local = s.substring(i, j + 1);
                    if (local.length() < ans.length()) {
                        ans = local;
                    }
                } else {
                    freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
                    break;
                }
            }
            j++;
        }
        return ans.length() > s.length() ? "" : ans;
    }

    private boolean matchFreq(HashMap<Character, Integer> freq, HashMap<Character, Integer> freqt) {
        for (char tKey : freqt.keySet()) {
            if (!freq.containsKey(tKey)) {
                return false;
            } else if (freq.get(tKey) < freqt.get(tKey)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("a", "aa"));
    }
}
