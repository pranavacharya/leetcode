
import java.util.HashSet;

public class TotalFruits {

    public int totalFruit(int[] tree) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        int local;
        while (j < tree.length) {
            if (!set.contains(tree[j])) {
                if (set.size() >= 2) {
                    local = j - i;
                    max = max > local ? max : local;
                    i++;
                    j = i;
                    set.clear();
                    set.add(tree[i]);
                } else {
                    set.add(tree[j]);
                    j++;
                }
            } else {
                j++;
            }
        }
        local = j - i;
        max = max > local ? max : local;
        return max;
    }

    public static void main(String args[]) {
        TotalFruits tf = new TotalFruits();
        int[] input = new int[]{0, 1, 6, 6, 4, 4, 6};
        System.out.println(tf.totalFruit(input));
    }
}
