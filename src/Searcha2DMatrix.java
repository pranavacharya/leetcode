
public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = row * column - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int middle = matrix[mid / column][mid % column];
            if (middle == target) {
                return true;
            } else if (middle > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        SearchA2DMatrix2 s2dm2 = new SearchA2DMatrix2();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(s2dm2.searchMatrix(matrix, 3));
    }
}
