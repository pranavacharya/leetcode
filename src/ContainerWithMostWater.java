
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        int area;
        int min;
        while (i < j) {
            min = Math.min(height[i], height[j]);
            area = min * (j - i);
            max = max > area ? max : area;
            if (min == height[i]) {
                i++;
            } else {
                j--;
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
