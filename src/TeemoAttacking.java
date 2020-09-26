
public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int time = duration;
        int last = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] < last + duration) {
                int newDiff = timeSeries[i] - last;
                last = timeSeries[i];
                time += newDiff;
            } else {
                last = timeSeries[i];
                time += duration;
            }
        }
        return time;
    }

    public static void main(String args[]) {
        TeemoAttacking ta = new TeemoAttacking();
        int[] timeSeries = new int[]{1, 2, 3, 4, 5};
        System.out.println(ta.findPoisonedDuration(timeSeries, 5));
    }
}
