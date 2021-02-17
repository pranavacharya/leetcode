
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(cwmw.maxArea(input));
    }
}
