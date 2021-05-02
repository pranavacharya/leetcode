
import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        int time = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i][0] + time <= courses[i][1]) {
                time += courses[i][0];
                maxHeap.add(courses[i][0]);
            } else {
                if (!maxHeap.isEmpty() && maxHeap.peek() > courses[i][0]) {
                    time -= maxHeap.poll();
                    time += courses[i][0];
                    maxHeap.add(courses[i][0]);
                }
            }
        }
        return maxHeap.size();
    }

    public static void main(String[] args) {
        CourseScheduleIII cs = new CourseScheduleIII();
        int[][] courses = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(cs.scheduleCourse(courses));
    }
}
