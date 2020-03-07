
import java.util.HashMap;
import java.util.PriorityQueue;

public class IncreasingDecreasingString {

    public String sortString(String s) {
        String ans = "";
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> minheap = new PriorityQueue<>();
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        boolean isloop = true;
        while (isloop) {
            for (char c : map.keySet()) {
                if (map.get(c) != 0) {
                    minheap.add(c);
                }
            }
            int minsize = minheap.size();
            for (int i = 0; i < minsize; i++) {
                char temp = minheap.remove();
                ans += temp;
                map.put(temp, map.get(temp) - 1);
            }
            minheap.clear();
            for (char c : map.keySet()) {
                if (map.get(c) != 0) {
                    maxheap.add(c);
                }
            }
            int maxsize = maxheap.size();
            for (int i = 0; i < maxsize; i++) {
                char temp = maxheap.remove();
                ans += temp;
                map.put(temp, map.get(temp) - 1);
            }
            maxheap.clear();
            isloop = false;
            for (int i : map.values()) {
                if (i != 0) {
                    isloop = true;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        String input = "aaaabbbbcccc";
        IncreasingDecreasingString ids = new IncreasingDecreasingString();
        System.out.println(ids.sortString(input));
    }
}
