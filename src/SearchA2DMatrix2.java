
public class SearchA2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int rightbound = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            int low = 0;
            int high = rightbound;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                    rightbound = Math.min(rightbound, mid);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        SearchA2DMatrix2 s2m = new SearchA2DMatrix2();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
        System.out.println(s2m.searchMatrix(matrix, 22));
    }
}
