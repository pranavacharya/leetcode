
import java.util.HashMap;

public class TotalFruits {

    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0;
        int j = 0;
        while (j < tree.length) {
            if (map.size() <= 2) {
                map.put(tree[j], j++);
            }

            if (map.size() > 2) {
                int min = tree.length - 1;
                for (int value : map.values()) {
                    min = Math.min(min, value);
                }
                i = min + 1;
                map.remove(tree[min]);
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    public static void main(String args[]) {
        TotalFruits tf = new TotalFruits();
        int[] input = new int[]{0, 1, 6, 6, 4, 4, 6};
        System.out.println(tf.totalFruit(input));
    }
}
