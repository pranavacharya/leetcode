
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] wordsInPara = paragraph.toLowerCase().split("[\\s@,&.;!'?$+-]+");
        HashSet<String> bannedSet = new HashSet<>();
        for (String i : banned) {
            bannedSet.add(i);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : wordsInPara) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        for (String i : wordsInPara) {
            if (!bannedSet.contains(i)) {
                maxHeap.add(i);
            }
        }
        return maxHeap.remove();
    }

    public static void main(String args[]) {
        MostCommonWord mcw = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(mcw.mostCommonWord(paragraph, banned));
    }
}
