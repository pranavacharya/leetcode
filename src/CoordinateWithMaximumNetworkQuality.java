
import java.util.Arrays;

public class CoordinateWithMaximumNetworkQuality {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int best = 0;
        int bestValue = 0;
        for (int i = 0; i < towers.length; i++) {
            int local = 0;
            for (int j = 0; j < towers.length; j++) {
                double dist = calculateDistance(towers[i][0], towers[i][1], towers[j][0], towers[j][1]);
                if (dist > radius) {
                    continue;
                }
                int signal = (int) (towers[j][2] / (1 + dist));
                local += signal;
            }
            if (local > bestValue) {
                bestValue = local;
                best = i;
            } else if (local == bestValue) {
                if (!(towers[best][0] < towers[i][0] || towers[best][0] == towers[i][0] && towers[best][1] < towers[i][1])) {
                    bestValue = local;
                    best = i;
                }
            }
        }

        return new int[]{towers[best][0], towers[best][1]};
    }

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String args[]) {
        CoordinateWithMaximumNetworkQuality cwmnq = new CoordinateWithMaximumNetworkQuality();
        int[][] towers = new int[][]{{3, 46, 2}, {3, 27, 46}, {7, 25, 50}, {32, 39, 3}, {4, 42, 37}, {20, 18, 48}, {13, 16, 23}, {22, 36, 24}, {40, 7, 26}, {16, 21, 1}, {46, 33, 34}, {19, 11, 19}, {31, 22, 41}, {37, 29, 20}, {18, 29, 28}, {36, 0, 45}, {39, 22, 37}, {25, 25, 45}, {0, 31, 15}, {44, 45, 13}, {18, 47, 23}, {47, 19, 26}, {48, 18, 32}};
        System.out.println(Arrays.toString(cwmnq.bestCoordinate(towers, 44)));
    }
}
