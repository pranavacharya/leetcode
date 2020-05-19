
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }

        int sum_clockwise = 0;
        for (int i = start; i < destination; i++) {
            sum_clockwise += distance[i];
        }
        int sum_anticlockwise = 0;
        for (int i = destination; i < distance.length; i++) {
            sum_anticlockwise += distance[i];
        }
        for (int i = 0; i < start; i++) {
            sum_anticlockwise += distance[i];
        }

        return Math.min(sum_clockwise, sum_anticlockwise);
    }

    public static void main(String args[]) {
        DistanceBetweenBusStops dbbs = new DistanceBetweenBusStops();
        int[] distance = new int[]{7, 10, 1, 12, 11, 14, 5, 0};
        System.out.println(dbbs.distanceBetweenBusStops(distance, 7, 2));
    }
}
