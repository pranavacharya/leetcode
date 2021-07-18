
import java.util.HashSet;

public class MaximumNumberofWordsYouCanType {

    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        String[] words = text.split(" ");
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.charAt(i))) {
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

    public static void main(String[] args) {
        MaximumNumberofWordsYouCanType mnwyct = new MaximumNumberofWordsYouCanType();
        System.out.println(mnwyct.canBeTypedWords("hello world", "ad"));
    }
}
