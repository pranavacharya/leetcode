
import java.util.Arrays;

public class BagOfToken {

    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) {
            return 0;
        }
        int maxScore = 0;
        int score = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (tokens[i] <= P) {
                P -= tokens[i];
                score++;
                i++;
            } else if (score > 0) {
                P += tokens[j];
                score--;
                j--;
            } else {
                break;
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public static void main(String args[]) {
        BagOfToken bt = new BagOfToken();
        int[] tokens = new int[]{100, 200, 300, 400};
        System.out.println(bt.bagOfTokensScore(tokens, 200));
    }
}
