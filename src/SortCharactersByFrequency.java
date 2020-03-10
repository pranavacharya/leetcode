
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char i : arr) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> (frequency.get(b) - frequency.get(a)));
        for (char i : frequency.keySet()) {
            maxHeap.add(i);
        }

        while (!maxHeap.isEmpty()) {
            char temp = maxHeap.remove();
            int times = frequency.get(temp);
            for (int i = 1; i <= times; i++) {
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        SortCharactersByFrequency scbf = new SortCharactersByFrequency();
        System.out.println(scbf.frequencySort("tree"));
    }
}
