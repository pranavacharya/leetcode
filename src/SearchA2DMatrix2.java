
public class SearchA2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j < n) {
            while (j > 0 && matrix[i][j] > target) {
                j--;
            }
            if (matrix[i][j] == target) {
                return true;
            }
            i++;
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
