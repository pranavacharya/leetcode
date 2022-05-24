
import java.util.Arrays;

public class MinimumLinestoRepresentaLineChart {

    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a, b) -> Double.compare(a[0], b[0]));

        if (stockPrices.length == 1) {
            return 0;
        }

        int count = 1;

        long y = stockPrices[1][1] - stockPrices[0][1];
        long x = stockPrices[1][0] - stockPrices[0][0];

        int i = 1;
        int j = 2;

        while (j < stockPrices.length) {
            long dy = stockPrices[j][1] - stockPrices[i][1];
            long dx = stockPrices[j][0] - stockPrices[i][0];

            if ((x * dy) != (y * dx)) {
                count++;
                y = dy;
                x = dx;
            }

            i++;
            j++;

        }

        return count;
    }

    public static void main(String[] args) {
        MinimumLinestoRepresentaLineChart mlrlc = new MinimumLinestoRepresentaLineChart();
//        int[][] stockPrices = new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 2}, {5, 1}, {6, 2}, {7, 1}};
//        int[][] stockPrices = new int[][]{{0, 3}, {1, 2}, {2, 1}, {3, 2}, {4, 1}, {5, 2}, {6, 1}};
        int[][] stockPrices = new int[][]{{1, 1}, {500000000, 499999999}, {1000000000, 999999998}};
        System.out.println(mlrlc.minimumLines(stockPrices));
    }
}
