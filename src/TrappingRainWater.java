
public class TrappingRainWater {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                left[i] = height[i];
                continue;
            }
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                right[i] = height[i];
                continue;
            }
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int water = 0;
        for (int i = 1; i < height.length; i++) {
            water += (Math.min(left[i], right[i]) - height[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw.trap(height));
    }
}
