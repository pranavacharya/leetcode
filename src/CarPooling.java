
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int capacityAtMoment = 0;
        for (int i = 0; i < timestamp.length; i++) {
            capacityAtMoment += timestamp[i];
            if (capacityAtMoment > capacity) {
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
