
import java.util.HashMap;
import java.util.HashSet;

public class CanConvertStringinKMoves {

    public boolean canConvertString(String s, String t, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        HashSet<Integer> set = new HashSet();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            int diff = 0;
            if ((s.charAt(i) - 'a') > (t.charAt(i) - 'a')) {
                diff = 26 - (s.charAt(i) - 'a') + (t.charAt(i) - 'a');
            } else {
                diff = (t.charAt(i) - 'a') - (s.charAt(i) - 'a');
            }
            if (diff == 0) {
                continue;
            }
            if (set.contains(diff)) {
                map.put(diff, map.get(diff) + 1);
            } else if (diff <= k) {
                set.add(diff);
                map.put(diff, 1);
            } else {
                return false;
            }
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (key + ((freq - 1) * 26) > k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        CanConvertStringinKMoves ccskm = new CanConvertStringinKMoves();
        System.out.println(ccskm.canConvertString("input", "ouput", 9));
        System.out.println(ccskm.canConvertString("abc", "bcd", 10));
        System.out.println(ccskm.canConvertString("aab", "bbb", 27));
        System.out.println(ccskm.canConvertString("iqssxdlb", "dyuqrwyr", 40));
        System.out.println(ccskm.canConvertString("qsxkjbfz", "xyfirptk", 73));
        System.out.println(ccskm.canConvertString("gxewjwruymylmc", "ytzjzxuklyticx", 81));
    }
}
