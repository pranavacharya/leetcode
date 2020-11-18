
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        if (intervals.length == 0) {
            return new int[][]{};
        }
        ArrayList<int[]> list = new ArrayList();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > curr[1]) {
                list.add(curr);
                curr = intervals[i];
            }
            if (intervals[i][1] < curr[1]) {
                continue;
            }
            if (intervals[i][0] <= curr[1]) {
                curr[1] = intervals[i][1];
            }
        }
        list.add(curr);
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String args[]) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(mi.merge(intervals)));
    }
}
