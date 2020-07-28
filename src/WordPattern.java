
import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        } else {
            HashMap<Character, String> map = new HashMap();
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(pattern.charAt(i))) {
                    if (!map.get(pattern.charAt(i)).equals(words[i])) {
                        return false;
                    }
                } else {
                    for (String word : map.values()) {
                        if (word.equals(words[i])) {
                            return false;
                        }
                    }
                    map.put(pattern.charAt(i), words[i]);
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
    }
}
