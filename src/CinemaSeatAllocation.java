
public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int max = 0;
        int[][] seats = new int[n + 1][11];
        for (int[] i : reservedSeats) {
            seats[i[0]][i[1]] = 1;
        }
        for (int i = 1; i <= n; i++) {
            boolean status25 = true;
            for (int j = 2; j <= 5; j++) {
                if (seats[i][j] == 1) {
                    status25 = false;
                }
            }
            boolean status47 = true;
            for (int j = 4; j <= 7; j++) {
                if (seats[i][j] == 1) {
                    status47 = false;
                }
            }
            boolean status69 = true;
            for (int j = 6; j <= 9; j++) {
                if (seats[i][j] == 1) {
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
