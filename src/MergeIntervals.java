
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    class obj {

        int a;
        int b;

        public obj(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<obj> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int j = 0;

        while (i < intervals.length) {
            obj latest = new obj(intervals[i][0], intervals[i][1]);
            while (j + 1 < intervals.length) {
                if (latest.b > intervals[j + 1][1]) {
                    j++;
                    continue;
                }
                if (intervals[j + 1][0] <= latest.b) {
                    latest.b = intervals[j + 1][1];
                    j++;
                } else {
                    break;
                }
            }
            i = ++j;
            result.add(latest);
        }
        int[][] res = new int[result.size()][];
        int index = 0;
        for (obj o : result) {
            res[index] = new int[]{o.a, o.b};
            index++;
        }
        return res;
    }

    public static void main(String args[]) {
        MergeIntervals mi = new MergeIntervals();
//        int[][] intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(mi.merge(intervals)));
    }
}
