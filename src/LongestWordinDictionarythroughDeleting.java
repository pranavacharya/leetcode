
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (int i = 0; i < d.size(); i++) {
            queue.add(d.get(i));
        }
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int index = s.length();
            boolean flag = true;
            for (int i = curr.length() - 1; i >= 0; i--) {
                index = s.substring(0, index).lastIndexOf(curr.charAt(i));
                if (index == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return curr;
            }
        }
        return "";
    }

    public static void main(String args[]) {
        LongestWordinDictionarythroughDeleting lwidtd = new LongestWordinDictionarythroughDeleting();
        List<String> d = new ArrayList();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        System.out.println(lwidtd.findLongestWord("abpcplea", d));
    }
}
