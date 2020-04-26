
public class MaximumScoreAfterSplittingaString {

    public int maxScore(String s) {
        int[] prefix = new int[s.length()];
        int[] suffix = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
            prefix[i] = count;
        }
        count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                count++;
            }
            suffix[i] = count;
        }
        int max = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            max = Math.max(max, prefix[i] + suffix[i + 1]);
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumScoreAfterSplittingaString msass = new MaximumScoreAfterSplittingaString();
        System.out.println(msass.maxScore("011101"));
        System.out.println(msass.maxScore("00111"));
        System.out.println(msass.maxScore("1111"));
    }
}
