
import java.util.Arrays;
import java.util.TreeMap;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {

            if (map.ceilingKey(intervals[i][1]) != null) {
                res[i] = map.get(map.ceilingKey(intervals[i][1]));
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        FindRightInterval fri = new FindRightInterval();
        int[][] intervals = new int[][]{{3, 4}, {2, 3}, {1, 2}};
        System.out.println(Arrays.toString(fri.findRightInterval(intervals)));
    }
}
