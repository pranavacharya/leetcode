
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int smaller = Math.min(start, destination);
        int larger = Math.max(start, destination);
        int a = 0;
        for (int i = smaller; i < larger; i++) {
            a += distance[i];
        }
        int b = 0;
        for (int i = larger; i != smaller; i = (i + 1) % distance.length) {
            b += distance[i % distance.length];
        }
        return Math.min(a, b);
    }

    public static void main(String args[]) {
        DistanceBetweenBusStops dbbs = new DistanceBetweenBusStops();
        int[] distance = new int[]{7, 10, 1, 12, 11, 14, 5, 0};
        System.out.println(dbbs.distanceBetweenBusStops(distance, 7, 2));
    }
}
