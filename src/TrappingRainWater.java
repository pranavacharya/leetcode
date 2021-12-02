
public class TrappingRainWater {

    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        int[] suffix = new int[height.length];
        suffix[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        int water = 0;

        for (int i = 0; i < height.length; i++) {
            water += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw.trap(height));
    }
}
