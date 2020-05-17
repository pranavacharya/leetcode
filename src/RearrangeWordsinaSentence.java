
import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeWordsinaSentence {

    class ObjComparator implements Comparator<WordObject> {

        public int compare(WordObject a, WordObject b) {
            if (a.word.length() == b.word.length()) {
                return a.order - b.order;
            }
            return a.word.length() - b.word.length();
        }
    }

    class WordObject {

        String word;
        int order;

        public WordObject(String word, int order) {
            this.word = word;
            this.order = order;
        }

    }

    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        PriorityQueue<WordObject> queue = new PriorityQueue(new ObjComparator());
        int index = 0;
        for (String word : words) {
            queue.add(new WordObject(word.toLowerCase(), index++));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.remove().word);
            sb.append(" ");
        }
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString().trim();
    }

    public static void main(String args[]) {
        RearrangeWordsinaSentence rwis = new RearrangeWordsinaSentence();
        System.out.println(rwis.arrangeWords("Leetcode is cool"));
    }
}
