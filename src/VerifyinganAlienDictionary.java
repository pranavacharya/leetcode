
import java.util.HashMap;

public class VerifyinganAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap();
        int index = 0;
        for (char c : order.toCharArray()) {
            orderMap.put(c, index++);
        }
        for (int i = 0; i + 1 < words.length; i++) {
            if (!compareString(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    public boolean compareString(String s1, String s2, HashMap<Character, Integer> order) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            int s1index = order.get(s1.charAt(i));
            int s2index = order.get(s2.charAt(i));
            if (s1index < s2index) {
                return true;
            } else if (s2index < s1index) {
                return false;
            }
        }
        return s1.length() <= s2.length();
    }

    public static void main(String args[]) {
        VerifyinganAlienDictionary vaad = new VerifyinganAlienDictionary();
        String[] words = new String[]{"hello", "leetcode"};
        System.out.println(vaad.isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
