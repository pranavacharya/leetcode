
import java.util.Arrays;

public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int max = 0;
        int[] row = new int[11];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(row, 0);
            for (int[] j : reservedSeats) {
                if (j[0] == i) {
                    row[j[1]] = 1;
                }
            }
            boolean status25 = true;
            for (int j = 2; j <= 5; j++) {
                if (row[j] == 1) {
                    status25 = false;
                }
            }
            boolean status47 = true;
            for (int j = 4; j <= 7; j++) {
                if (row[j] == 1) {
                    status47 = false;
                }
            }
            boolean status69 = true;
            for (int j = 6; j <= 9; j++) {
                if (row[j] == 1) {
                    status69 = false;
                }
            }
            if (status25 && status69) {
                max = max + 2;
            } else if (status25 || status47 || status69) {
                max++;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        CinemaSeatAllocation csa = new CinemaSeatAllocation();
        int[][] reserverdSeats = new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(csa.maxNumberOfFamilies(3, reserverdSeats));
    }
}
