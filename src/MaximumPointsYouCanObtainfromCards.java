
public class MaximumPointsYouCanObtainfromCards {

    public int maxScore(int[] cardPoints, int k) {
        int[] prefix = new int[k + 1];
        int[] suffix = new int[k + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + cardPoints[i - 1];
        }
        suffix[k] = 0;
        for (int i = cardPoints.length - 1, len = k - 1; i >= 0 && len >= 0; i--, len--) {
            suffix[len] = suffix[len + 1] + cardPoints[i];
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            int score = prefix[i] + suffix[i];
            max = Math.max(max, score);
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumPointsYouCanObtainfromCards mpycofc = new MaximumPointsYouCanObtainfromCards();
        int[] cardPoints = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
        System.out.println(mpycofc.maxScore(cardPoints, 3));
    }
}
