
import java.util.Stack;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                int area = 0;
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
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
        while (!stack.isEmpty()) {
            int area = 0;
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = heights[top] * heights.length;
            } else {
                area = heights[top] * (heights.length - stack.peek() - 1);
            }
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String args[]) {
        LargestRectangleinHistogram lrh = new LargestRectangleinHistogram();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(lrh.largestRectangleArea(heights));
    }
}
