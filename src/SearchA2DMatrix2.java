
public class SearchA2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int column = matrix[0].length - 1;
        int row = 0;

        while (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        SearchA2DMatrix2 s2m = new SearchA2DMatrix2();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
        System.out.println(s2m.searchMatrix(matrix, 30));
    }
}
