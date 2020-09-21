
import java.util.Arrays;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Double.compare(a[1], b[1]));
        for (int i = 0; i < trips.length; i++) {
            int seatsreq = trips[i][0];
            int start = trips[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (trips[j][2] > start) {
                    seatsreq += trips[j][0];
                }
            }
            if (seatsreq > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        CarPooling cp = new CarPooling();
        int[][] trips = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        System.out.println(cp.carPooling(trips, 11));
    }
}
