
import java.util.Arrays;

public class NonoverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[last][1] <= intervals[i][0]) {
                last = i;
            } else if (intervals[last][1] >= intervals[i][1]) {
                count++;
                last = i;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NonoverlappingIntervals noi = new NonoverlappingIntervals();
        int[][] intervals = new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(noi.eraseOverlapIntervals(intervals));
    }
}
