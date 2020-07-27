
import java.util.HashSet;

public class NumberofGoodWaystoSplitaString {

    public int numSplits(String s) {
        int[] prefix = new int[s.length()];
        int[] suffix = new int[s.length()];
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            prefix[i] = set.size();
        }
        set.clear();
        for (int i = s.length() - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            suffix[i] = set.size();
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (prefix[i] == suffix[i + 1]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        NumberofGoodWaystoSplitaString ngwtss = new NumberofGoodWaystoSplitaString();
        System.out.println(ngwtss.numSplits("aacaba"));
    }
}
