
import java.util.Arrays;

public class MaximumScoreFromRemovingStones {

    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int diff = c - b;
        if (a <= diff) {
            b += a;
            a = 0;
            return b;
        } else {
            b += diff;
            a -= diff;
            return b + a / 2;
        }
    }

    public static void main(String args[]) {
        MaximumScoreFromRemovingStones msrs = new MaximumScoreFromRemovingStones();
        System.out.println(msrs.maximumScore(6, 2, 1));
    }
}
