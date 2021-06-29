
import java.util.Stack;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        Stack<Integer> stack = new Stack();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                ans = Math.max(ans, Math.min(height[i], height[stack.peek()]) * (i - stack.peek()));
                Stack<Integer> temp = new Stack();
                while (!stack.isEmpty()) {
                    int index = stack.pop();
                    ans = Math.max(ans, Math.min(height[i], height[index]) * (i - index));
                    temp.push(index);

                }
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
                if (height[stack.peek()] < height[i]) {
                    stack.push(i);
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(cwmw.maxArea(input));
    }
}
