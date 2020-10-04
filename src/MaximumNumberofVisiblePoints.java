
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class MaximumNumberofVisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int maxVisiblePoints = 0;
        int samePoint = 0;
        ArrayList<Double> rads = new ArrayList();
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            int x1 = x - location.get(0);
            int y1 = y - location.get(1);
            if (x1 == y1 && y1 == 0) {
                samePoint++;
            } else {
                if (x1 == 0) {
                    if (y1 > 0) {
                        rads.add(90.0);
                    } else {
                        rads.add(270.0);
                    }
                } else {
                    double calAngle = Math.toDegrees(Math.atan2(y1, x1));
                    if (calAngle < 0) {
                        calAngle = 360 + calAngle;
                    }
                    rads.add(calAngle);
                    rads.add(calAngle + 360);
                }
            }
        }
        Collections.sort(rads);
        double visionRange = angle;
        Deque<Double> deque = new ArrayDeque();
        for (Double point : rads) {
            deque.addLast(point);
            while (!deque.isEmpty()) {
                if (deque.peek() < point - visionRange) {
                    deque.pollFirst();
                } else {
                    break;
                }
            }
            maxVisiblePoints = Math.max(maxVisiblePoints, deque.size());
        }
        return maxVisiblePoints + samePoint;
    }

    public static void main(String args[]) {
        MaximumNumberofVisiblePoints mnvp = new MaximumNumberofVisiblePoints();
        List<List<Integer>> points = new ArrayList();
        List<Integer> first = new ArrayList();
        List<Integer> second = new ArrayList();
        first.add(0);
        first.add(0);
        second.add(0);
        second.add(2);
        int angle = 90;
        List<Integer> location = new ArrayList();
        location.add(1);
        location.add(1);
        points.add(first);
        points.add(second);
//        List<List<Integer>> points = new ArrayList();
//        List<Integer> first = new ArrayList();
//        List<Integer> second = new ArrayList();
//        List<Integer> third = new ArrayList();
//        first.add(2);
//        first.add(1);
//        second.add(2);
//        second.add(2);
//        third.add(3);
//        third.add(3);
//        int angle = 90;
//        List<Integer> location = new ArrayList();
//        location.add(1);
//        location.add(1);
//        points.add(first);
//        points.add(second);
//        points.add(third);
        System.out.println(mnvp.visiblePoints(points, angle, location));
    }
}
