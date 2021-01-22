
import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        if (matrix.length == 0) {
            return area;
        }
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (matrix[i][j] == '0') {
                    arr[i][j] = 0;
                } else {
                    if (i == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Stack<Integer> stack = new Stack();
            for (int j = 0; j < arr[i].length; j++) {
                if (stack.isEmpty()) {
                    stack.push(j);
                } else if (!stack.isEmpty() && arr[i][stack.peek()] <= arr[i][j]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && arr[i][stack.peek()] > arr[i][j]) {
                        int index = stack.pop();
                        int height = arr[i][index];
                        int local = 0;
                        if (stack.isEmpty()) {
                            local = height * j;
                        } else {
                            local = height * (j - stack.peek() - 1);
                        }
                        area = Math.max(area, local);
                    }
                    stack.push(j);
                }
            }

            while (!stack.isEmpty()) {
                int index = stack.pop();
                int height = arr[i][index];
                int local = 0;
                if (stack.isEmpty()) {
                    local = height * arr[i].length;
                } else {
                    local = height * (arr[i].length - stack.peek() - 1);
                }
                area = Math.max(area, local);
            }
        }
        return area;
    }

    public static void main(String args[]) {
        MaximalRectangle mr = new MaximalRectangle();
//        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
//        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = new char[][]{{'1', '1'}};
        System.out.println(mr.maximalRectangle(matrix));
    }
}
