
import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {

        final Comparator<int[]> intervalComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return -1 * (o1[1] - o2[1]);
                } else {
                    return (o1[0] - o2[0]);
                }
            }
        };
        Arrays.sort(intervals, intervalComparator);
        int count = 0;
        for (int i = 0; i < intervals.length;) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length) {
                if (intervals[j][1] <= end) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
            i = j;
        }

        return intervals.length - count;
    }

    public static void main(String args[]) {
        RemoveCoveredIntervals rci = new RemoveCoveredIntervals();
        int[][] intervals = new int[][]{{1, 2}, {1, 4}, {3, 4}};
        System.out.println(rci.removeCoveredIntervals(intervals));
    }
}
