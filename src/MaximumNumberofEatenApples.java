
import java.util.TreeMap;

public class MaximumNumberofEatenApples {

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        TreeMap<Integer, Integer> map = new TreeMap();
        int count = 0;
        int day = 1;
        for (int i = 0; i < n; i++) {
            map.put(i + days[i], map.getOrDefault(i + days[i], 0) + apples[i]);
            Integer closest = map.ceilingKey(day);
            if (closest != null) {
                count++;
                map.put(closest, map.get(closest) - 1);
                if (map.get(closest) == 0) {
                    map.remove(closest);
                }
            }
            day++;
        }
        while (map.ceilingKey(day) != null) {
            Integer closest = map.ceilingKey(day);
            map.put(closest, map.get(closest) - 1);
            if (map.get(closest) == 0) {
                map.remove(closest);
            }
            count++;
            day++;
        }

        return count;
    }

    public static void main(String args[]) {
        MaximumNumberofEatenApples mnea = new MaximumNumberofEatenApples();
        int[] apples = new int[]{1, 2, 3, 5, 2};
        int[] days = new int[]{3, 2, 1, 4, 2};
        System.out.println(mnea.eatenApples(apples, days));
    }
}
