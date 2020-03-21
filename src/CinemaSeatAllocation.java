
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int max = 2 * n;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] j : reservedSeats) {
            if (map.containsKey(j[0])) {
                ArrayList list = new ArrayList(map.get(j[0]));
                list.add(j[1]);
                map.put(j[0], new ArrayList(list));
            } else {
                ArrayList list = new ArrayList();
                list.add(j[1]);
                map.put(j[0], new ArrayList(list));
            }
        }
        int[] row = new int[11];
        for (int i : map.keySet()) {
            Arrays.fill(row, 0);
            ArrayList list = map.get(i);
            while (!list.isEmpty()) {
                int j = (int) list.remove(0);
                row[j] = 1;
            }
            boolean reserved25 = false;
            for (int j = 2; j <= 5; j++) {
                if (row[j] == 1) {
                    reserved25 = true;
                }
            }
            boolean reserved47 = false;
            for (int j = 4; j <= 7; j++) {
                if (row[j] == 1) {
                    reserved47 = true;
                }
            }
            boolean reserved69 = false;
            for (int j = 6; j <= 9; j++) {
                if (row[j] == 1) {
                    reserved69 = true;
                }
            }
            if (reserved25 && reserved69 && reserved47) {
                max = max - 2;
            } else if (reserved25 && reserved47) {
                max--;
            } else if (reserved69 && reserved47) {
                max--;
            } else if (reserved25 || reserved69 || reserved47) {
                max--;
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
