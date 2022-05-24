
import java.util.TreeSet;

public class KEmptySlots {

    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < bulbs.length; i++) {
            int index = bulbs[i];
            Integer next = set.higher(index);
            if (next != null && next == index + 1 + k) {
                return i + 1;
            }
            Integer prev = set.lower(index);
            if (prev != null && prev == index - 1 - k) {
                return i + 1;
            }
            set.add(index);
        }
        return -1;
    }

    public static void main(String[] args) {
        KEmptySlots ks = new KEmptySlots();
        int[] bulbs = new int[]{1, 3, 2};
        System.out.println(ks.kEmptySlots(bulbs, 1));
    }
}
