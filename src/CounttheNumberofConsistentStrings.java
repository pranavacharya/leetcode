
import java.util.HashSet;

public class CounttheNumberofConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CounttheNumberofConsistentStrings cncs = new CounttheNumberofConsistentStrings();
        String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(cncs.countConsistentStrings("ab", words));
    }
}
