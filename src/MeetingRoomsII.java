
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> intervals[a][1] - intervals[b][1]);

        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            while (!queue.isEmpty() && intervals[queue.peek()][1] <= intervals[i][0]) {
                queue.poll();
            }

            queue.add(i);

            count = Math.max(queue.size(), count);
        }

        return count;
    }

    public static void main(String[] args) {
        MeetingRoomsII mr = new MeetingRoomsII();
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(mr.minMeetingRooms(intervals));
    }
}
