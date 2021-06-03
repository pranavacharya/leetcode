
import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCut {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxArea = 0;
        int hLast = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i <= horizontalCuts.length; i++) {
            int height = 0;
            if (i == horizontalCuts.length) {
                height = h - hLast;
            } else {
                height = horizontalCuts[i] - hLast;
            }
            int vLast = 0;
            for (int j = 0; j < verticalCuts.length; j++) {
                int width = verticalCuts[j] - vLast;
                maxArea = Math.max(maxArea, height * width);
                vLast = verticalCuts[j];
            }
            int lastWidth = w - vLast;
            maxArea = Math.max(maxArea, height * lastWidth);
            if (i != horizontalCuts.length) {
                hLast = horizontalCuts[i];
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCut mapcahvc
                = new MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCut();
        int[] horizontalCuts = new int[]{3, 1};
        int[] verticalCuts = new int[]{1};
        System.out.println(mapcahvc.maxArea(5, 4, horizontalCuts, verticalCuts));
    }
}
