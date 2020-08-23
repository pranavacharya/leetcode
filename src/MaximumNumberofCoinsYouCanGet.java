
import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {

    public int maxCoins(int[] piles) {
        int max = 0;
        Arrays.sort(piles);
        int n = piles.length / 3;
        for (int i = piles.length - 2; i >= 0 && n > 0; n--, i = i - 2) {
            max += piles[i];
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumNumberofCoinsYouCanGet mncg = new MaximumNumberofCoinsYouCanGet();
        int[] piles = new int[]{2, 4, 1, 2, 7, 8};
        System.out.println(mncg.maxCoins(piles));
    }
}
