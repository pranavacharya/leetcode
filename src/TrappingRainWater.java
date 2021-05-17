
import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int water = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i <= maxIndex; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (height[stack.peek()] <= height[i]) {
                water += (height[stack.peek()] * (i - stack.peek() - 1));
                stack.push(i);
            } else {
                water -= height[i];
            }
        }
        stack.clear();
        for (int i = height.length - 1; i >= maxIndex; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (height[stack.peek()] <= height[i]) {
                water += (height[stack.peek()] * (stack.peek() - i - 1));
                stack.push(i);
            } else {
                water -= height[i];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw.trap(height));
    }
}
