
import java.util.ArrayList;
import java.util.HashMap;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        HashMap<Integer, ArrayList<Integer>> start = new HashMap();
        HashMap<Integer, ArrayList<Integer>> end = new HashMap();
        for (int i = 0; i < intervals.length; i++) {
            start.putIfAbsent(intervals[i][0], new ArrayList());
            end.putIfAbsent(intervals[i][1], new ArrayList());
            start.get(intervals[i][0]).add(i);
            end.get(intervals[i][1]).add(i);
        }
        int count = 0;
        int ans = 0;
        for (int i = 0; i <= 1000000; i++) {
            ArrayList<Integer> startlist = start.getOrDefault(i, new ArrayList());
            ArrayList<Integer> endlist = end.getOrDefault(i, new ArrayList());

            count += startlist.size();
            count -= endlist.size();
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
