
import java.util.HashMap;

public class LargestSubstringBetweenTwoEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int last = map.get(s.charAt(i));
                max = Math.max(i - last - 1, max);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LargestSubstringBetweenTwoEqualCharacters lsbtec = new LargestSubstringBetweenTwoEqualCharacters();
        System.out.println(lsbtec.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(lsbtec.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(lsbtec.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(lsbtec.maxLengthBetweenEqualCharacters("cabbac"));
    }
}
