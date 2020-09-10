
import java.util.HashSet;

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] translation = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append(translation[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String args[]) {
        UniqueMorseCodeWords umcw = new UniqueMorseCodeWords();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(umcw.uniqueMorseRepresentations(words));
    }
}
