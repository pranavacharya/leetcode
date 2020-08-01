
public class CellswithOddValuesinaMatrix {

    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] + col[j]) % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CellswithOddValuesinaMatrix cwovm = new CellswithOddValuesinaMatrix();
        int[][] indices = new int[][]{{0, 1}, {1, 1}};
        System.out.println(cwovm.oddCells(2, 3, indices));
    }
}
