
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
            for (int j = 0; j < arr[i].length; j++) {
                int local = 0;
                int min = arr[i][j];
                for (int k = j; k >= 0; k--) {
                    min = Math.min(min, arr[i][k]);
                    local = Math.max(local, min * (j - k + 1));
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
