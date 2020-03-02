
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int value;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                value = Math.min(height[i], height[j]) * Math.abs(i - j);
                max = max < value ? value : max;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(cwmw.maxArea(input));
    }
}
