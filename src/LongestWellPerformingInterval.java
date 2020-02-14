
public class LongestWellPerformingInterval {

    public int dynamicPrograming(int[] hours, int[] dp) {
        int i = 0;
        int max = 0;
        while (i < hours.length) {
            for (int j = i; j < hours.length; j++) {
                if (i == j) {
                    dp[j] = hours[j];
                } else {
                    dp[j] = dp[j - 1] + hours[j];
                }
                if (dp[j] > 0) {
                    max = (max > (j - i + 1)) ? max : (j - i + 1);
                }
            }
            i++;
        }
        return max;
    }

    public int longestWPI(int[] hours) {
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
        }
        return dynamicPrograming(hours, new int[hours.length]);
    }

    public static void main(String args[]) {
        LongestWellPerformingInterval lwpi = new LongestWellPerformingInterval();
        int[] hours = {0, 9, 6, 0, 9, 6, 9};
        System.out.println(lwpi.longestWPI(hours));
    }
}
