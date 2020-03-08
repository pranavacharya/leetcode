
import java.util.HashSet;

public class BulbSwitcher3 {

    public int numTimesAllBlue(int[] light) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int k = 0; k < light.length; k++) {
            set.add(light[k]);
            int i = k + 1;
            while (i > 0) {
                if (set.contains(i)) {
                    i--;
                } else {
                    break;
                }
            }
            if (i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        BulbSwitcher3 bs3 = new BulbSwitcher3();
        int[] light = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(bs3.numTimesAllBlue(light));
    }
}
