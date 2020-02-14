
public class LongestWellPerformingInterval {

    public int longestWPI(int[] hours) {
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
        }
        int i = 0;
        int max = 0;
        while (i < hours.length) {
            for (int j = i; j < hours.length; j++) {
                if (sum(i, j, hours) > 0) {
                    max = (max > (j - i + 1)) ? max : (j - i + 1);
                }
            }
            i++;
        }
        return max;
    }

    public int sum(int start, int end, int[] arr) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void main(String args[]) {
        LongestWellPerformingInterval lwpi = new LongestWellPerformingInterval();
        int[] hours = {0, 9, 6, 0, 9, 6, 9};
        System.out.println(lwpi.longestWPI(hours));
    }
}
