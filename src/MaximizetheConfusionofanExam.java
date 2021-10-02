
public class MaximizetheConfusionofanExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(slidingWindow(answerKey, k, 'T'), slidingWindow(answerKey, k, 'F'));
    }

    private int slidingWindow(String s, int k, char c) {
        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < s.length()) {
            if (j < s.length() && s.charAt(j) == c) {
                j++;
            } else {
                if (k > 0) {
                    k--;
                    j++;
                } else {
                    if (s.charAt(i) != c) {
                        k++;
                    }
                    i++;
                }
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximizetheConfusionofanExam mtce = new MaximizetheConfusionofanExam();
        System.out.println(mtce.maxConsecutiveAnswers("TTFF", 2));
    }
}
