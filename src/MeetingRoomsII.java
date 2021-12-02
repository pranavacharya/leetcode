
import java.util.ArrayList;
import java.util.HashMap;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        HashMap<Integer, Integer> start = new HashMap();
        HashMap<Integer, Integer> end = new HashMap();
        for (int i = 0; i < intervals.length; i++) {
            start.put(intervals[i][0], start.getOrDefault(intervals[i][0], 0) + 1);
            end.put(intervals[i][1], end.getOrDefault(intervals[i][1], 0) + 1);
        }
        int count = 0;
        int ans = 0;
        for (int i = 0; i <= 1000000; i++) {
            int startCount = start.getOrDefault(i, 0);
            int endCount = end.getOrDefault(i, 0);

            count += startCount;
            count -= endCount;
            ans = Math.max(ans, count);

        }
        return ans;
    }

    public static void main(String[] args) {
        MeetingRoomsII mr = new MeetingRoomsII();
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(mr.minMeetingRooms(intervals));
    }
}
