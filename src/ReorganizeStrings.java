
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeStrings {

    public String reorganizeString(String S) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(map.keySet());
        while (maxHeap.size() > 1) {
            char last = maxHeap.remove();
            char secondlast = maxHeap.remove();

            sb.append(last);
            sb.append(secondlast);

            map.put(last, map.get(last) - 1);
            map.put(secondlast, map.get(secondlast) - 1);
            if (map.get(last) != 0) {
                maxHeap.add(last);
            }
            if (map.get(secondlast) != 0) {
                maxHeap.add(secondlast);
            }
        }
        if (maxHeap.size() > 0) {
            char last = maxHeap.remove();
            if (map.get(last) > 1) {
                return "";
            } else {
                sb.append(last);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        ReorganizeStrings rs = new ReorganizeStrings();
        System.out.println(rs.reorganizeString("baaba"));
    }
}
