
public class MaximumPointsYouCanObtainfromCards {

    public int maxScore(int[] cardPoints, int k) {
        int[] modified = new int[2 * cardPoints.length];
        for (int i = 0; i < cardPoints.length; i++) {
            modified[i] = cardPoints[i];
            modified[i + cardPoints.length] = cardPoints[i];
        }
        int start = cardPoints.length - k;
        int end = start;
        int ans = 0;
        int sum = 0;
        while (start <= cardPoints.length) {
            while (end - start < k) {
                sum += modified[end++];
            }
            ans = Math.max(ans, sum);
            sum -= modified[start++];
        }
        return ans;
    }

    public static void main(String args[]) {
        MaximumPointsYouCanObtainfromCards mpycofc = new MaximumPointsYouCanObtainfromCards();
        int[] cardPoints = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
        System.out.println(mpycofc.maxScore(cardPoints, 3));
    }
}
