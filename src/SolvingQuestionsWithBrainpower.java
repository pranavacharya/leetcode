
import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {

    long[] dp;

    public long mostPoints(int[][] questions) {
        this.dp = new long[questions.length];
        Arrays.fill(this.dp, -1);
        return helper(questions, 0);
    }

    private long helper(int[][] questions, int index) {
        if (index >= questions.length) {
            return 0;
        }
        if (this.dp[index] != -1) {
            return this.dp[index];
        }

        long ans = 0;

        ans = Math.max(ans, helper(questions, index + 1));
        ans = Math.max(ans, questions[index][0] + helper(questions, index + 1 + questions[index][1]));

        return this.dp[index] = ans;
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower sqwb = new SolvingQuestionsWithBrainpower();
        int[][] questions = new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(sqwb.mostPoints(questions));
    }
}
