
import java.util.Stack;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i <= heights.length; i++) {
            int height = 0;
            if (i != heights.length) {
                height = heights[i];
            }
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (!stack.isEmpty() && heights[stack.peek()] <= height) {
                stack.push(i);
            } else {
                int area = 0;
                while (!stack.isEmpty() && heights[stack.peek()] > height) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        area = heights[top] * i;
                    } else {
                        area = heights[top] * (i - stack.peek() - 1);
                    }
                    max = Math.max(max, area);
                }
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LargestRectangleinHistogram lrh = new LargestRectangleinHistogram();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(lrh.largestRectangleArea(heights));
    }
}
