
import java.util.HashSet;

public class LongestSubstringOfAllVowelsinOrder {

    public int longestBeautifulSubstring(String word) {
        int max = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet();
        set.add(word.charAt(0));
        while (j + 1 <= word.length() - 1) {
            if (word.charAt(j + 1) >= word.charAt(j)) {
                set.add(word.charAt(j + 1));
                j++;
            } else {
                if (set.size() == 5) {
                    max = Math.max(max, j - i + 1);
                }
                set.clear();
                i = j + 1;
                j = i;
                set.add(word.charAt(j));
            }
        }
        if (set.size() == 5) {
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringOfAllVowelsinOrder lsavo = new LongestSubstringOfAllVowelsinOrder();
        System.out.println(lsavo.longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
//        System.out.println(lsavo.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
