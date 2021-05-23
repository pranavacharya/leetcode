
public class MinimumSpeedtoArriveonTime {

    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int) 1e7 + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValidSpeed(dist, hour, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high == (int) 1e7 + 1 ? -1 : high;
    }

    private boolean isValidSpeed(int[] dist, double hour, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i != dist.length - 1) {
                time += Math.ceil((double) dist[i] / speed);
            } else {
                time += ((double) dist[i] / speed);
            }
        }
        return time <= hour;
    }

    public static void main(String[] args) {
        MinimumSpeedtoArriveonTime msat = new MinimumSpeedtoArriveonTime();
        int[] dist = new int[]{5, 3, 4, 6, 2, 2, 7};
        System.out.println(msat.minSpeedOnTime(dist, 10.92));
    }
}
