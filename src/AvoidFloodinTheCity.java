
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class AvoidFloodinTheCity {

    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        HashMap<Integer, Integer> map = new HashMap();
        TreeSet<Integer> zero = new TreeSet();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zero.add(i);
            } else {
                if (map.containsKey(rains[i])) {
                    Integer nextZero = zero.ceiling(map.get(rains[i]));
                    if (nextZero == null) {
                        return new int[]{};
                    }
                    ans[nextZero] = rains[i];
                    zero.remove(nextZero);
                }
                map.put(rains[i], i);
                ans[i] = -1;
            }
        }
        for (int i : zero) {
            ans[i] = 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        AvoidFloodinTheCity afic = new AvoidFloodinTheCity();
        int[] rains = new int[]{1, 2, 0, 0, 2, 1};
        System.out.println(Arrays.toString(afic.avoidFlood(rains)));
    }
}
