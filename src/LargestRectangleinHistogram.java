
import java.util.Stack;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int max = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (heights[stack.peek()] > heights[i]) {
                    int curr = stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, heights[curr] * i);
                        break;
                    } else {
                        max = Math.max(max, heights[curr] * (i - stack.peek() - 1));
                    }
                }
                stack.push(i);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (stack.isEmpty()) {
                max = Math.max(max, heights[curr] * i);
            } else {
                max = Math.max(max, heights[curr] * (i - stack.peek() - 1));
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LargestRectangleinHistogram lrh = new LargestRectangleinHistogram();
        int[] heights = new int[]{1, 2, 3, 4, 5};
        System.out.println(lrh.largestRectangleArea(heights));
    }
}
