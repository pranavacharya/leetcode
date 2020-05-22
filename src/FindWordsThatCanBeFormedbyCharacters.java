
import java.util.HashMap;

public class FindWordsThatCanBeFormedbyCharacters {

    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        HashMap<Character, Integer> frequency = new HashMap();
        for (char c : chars.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (String word : words) {
            HashMap<Character, Integer> temp = new HashMap(frequency);
            boolean isPresent = true;
            char[] arr = word.toCharArray();
            for (char c : arr) {
                if (temp.containsKey(c) && temp.get(c) > 0) {
                    temp.put(c, temp.get(c) - 1);
                } else {
                    isPresent = false;
                    break;
                }
            }
            if (isPresent) {
                ans += word.length();
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        FindWordsThatCanBeFormedbyCharacters fwtcbfbc = new FindWordsThatCanBeFormedbyCharacters();
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(fwtcbfbc.countCharacters(words, chars));
    }
}
