
import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCut {

    private int mod = (int) 1e9 + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHorDiff = 0;
        for (int i = 0; i <= horizontalCuts.length; i++) {
            if (i == 0) {
                maxHorDiff = Math.max(maxHorDiff, horizontalCuts[i] - 0);
            } else if (i == horizontalCuts.length) {
                maxHorDiff = Math.max(maxHorDiff, h - horizontalCuts[i - 1]);
            } else {
                maxHorDiff = Math.max(maxHorDiff, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
        }
        long maxVerDiff = 0;
        for (int i = 0; i <= verticalCuts.length; i++) {
            if (i == 0) {
                maxVerDiff = Math.max(maxVerDiff, verticalCuts[i] - 0);
            } else if (i == verticalCuts.length) {
                maxVerDiff = Math.max(maxVerDiff, w - verticalCuts[i - 1]);
            } else {
                maxVerDiff = Math.max(maxVerDiff, verticalCuts[i] - verticalCuts[i - 1]);
            }
        }
        return (int) (maxHorDiff % mod * maxVerDiff % mod) % mod;
    }

    public static void main(String[] args) {
        MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCut mapcahvc
                = new MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCut();
        int[] horizontalCuts = new int[]{3};
        int[] verticalCuts = new int[]{3};
        System.out.println(mapcahvc.maxArea(5, 4, horizontalCuts, verticalCuts));
    }
}
