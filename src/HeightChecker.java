
import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] original = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            original[i] = heights[i];
        }
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (original[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        HeightChecker hc = new HeightChecker();
        int[] heights = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(hc.heightChecker(heights));
    }
}
