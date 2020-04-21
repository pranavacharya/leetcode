
public class LeftmostColumnwithatLeastaOne {

    public int leftMostColumnWithOne(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] != 0) {
                min = Math.min(min, binarySearchLeast(matrix[i]));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int binarySearchLeast(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        LeftmostColumnwithatLeastaOne lmc = new LeftmostColumnwithatLeastaOne();
        int[][] matrix = new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
        System.out.println(lmc.leftMostColumnWithOne(matrix));
    }
}
