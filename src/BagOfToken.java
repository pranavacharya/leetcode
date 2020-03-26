
import java.util.Arrays;

public class BagOfToken {

    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) {
            return 0;
        }
        int max = 0;
        int points = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        main:
        while (true) {
            boolean status = true;
            while (P < tokens[i] && points > 0) {
                points--;
                P += tokens[j--];
                if (j < i) {
                    break main;
                }
                status = false;
            }
            while (tokens[i] <= P) {
                P -= tokens[i++];
                points++;
                max = Math.max(max, points);
                if (j < i) {
                    break main;
                }
                status = false;
            }
            if (status) {
                break;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        BagOfToken bt = new BagOfToken();
        int[] tokens = new int[]{100, 200, 300, 400};
        System.out.println(bt.bagOfTokensScore(tokens, 200));
    }
}
