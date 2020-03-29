
import java.util.HashMap;

public class FindLuckyIntegerInArray {

    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int largest = -1;
        for (int k : map.keySet()) {
            if (map.get(k) == k && k > largest) {
                largest = k;
            }
        }
        return largest;
    }
}
