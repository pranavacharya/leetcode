
public class LongestWellPerformingInterval {

    public int dynamicPrograming(int[] hours, int[][] dp) {
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
                if (i == j) {
                    dp[i][j] = hours[i];
                } else {
                    dp[i][j] = dp[i][j - 1] + hours[j];
                }
                if (dp[i][j] > 0) {
                    max = (max > (j - i + 1)) ? max : (j - i + 1);
                }
            }
            i++;
        }
        return max;
    }

    public int longestWPI(int[] hours) {
        return dynamicPrograming(hours, new int[hours.length][hours.length]);
    }

    public static void main(String args[]) {
        LongestWellPerformingInterval lwpi = new LongestWellPerformingInterval();
        int[] hours = {0, 9, 6, 0, 9, 6, 9};
        System.out.println(lwpi.longestWPI(hours));
    }
}
