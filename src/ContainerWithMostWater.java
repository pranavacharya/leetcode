
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;
        while (i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }

    public static void main(String args[]) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(cwmw.maxArea(input));
    }
}
