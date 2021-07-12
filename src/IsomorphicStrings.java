
import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap();
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                char mapping = map.get(s.charAt(i));
                if (t.charAt(i) != mapping) {
                    return false;
                }
            } else {
                if (set.contains(t.charAt(i))) {
                    return false;
                }
                set.add(t.charAt(i));
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String args[]) {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic("egg", "add"));
    }
}
