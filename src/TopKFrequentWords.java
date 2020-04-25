
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> list = new ArrayList<>();
        Arrays.sort(words);
        HashMap<String, Integer> frequency = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> ((frequency.get(a) == frequency.get(b)) ? b.compareTo(a) : frequency.get(a) - frequency.get(b)));
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        for (String key : frequency.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        while (!minHeap.isEmpty()) {
            list.add(minHeap.remove());
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String args[]) {
        TopKFrequentWords tkfw = new TopKFrequentWords();
//        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(tkfw.topKFrequent(words, 4));
    }
}
