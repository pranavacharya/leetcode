
import java.util.Arrays;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int[][] interval = new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                interval[i][j] = intervals[i][j];
            }
            interval[i][2] = i;
        }
        Arrays.sort(interval, (a, b) -> Double.compare(a[0], b[0]));
        int[] res = new int[intervals.length];
        for (int i = 0; i < interval.length; i++) {
            int find = intervals[i][1];
            int low = 0;
            int high = interval.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (interval[mid][0] == find) {
                    low = mid;
                    break;
                } else if (interval[mid][0] < find) {
                    low = low + 1;
                } else {
                    high = mid;
                }
            }
            if (interval[low][0] < find) {
                res[i] = -1;
            } else {
                res[i] = interval[low][2];
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
