
import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {
        if (n == 0) {
            return cells;
        }
        HashSet<String> set = new HashSet();
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[8];
            for (int j = 1; j < 7; j++) {
                if (cells[j + 1] == cells[j - 1]) {
                    temp[j] = 1;
                } else {
                    temp[j] = 0;
                }
            }
            if (!set.add(Arrays.toString(temp))) {
                break;
            }
            cells = temp;
        }
        n = n % set.size();
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[8];
            for (int j = 1; j < 7; j++) {
                if (cells[j + 1] == cells[j - 1]) {
                    temp[j] = 1;
                } else {
                    temp[j] = 0;
                }
            }
            cells = temp;
        }
        return cells;
    }

    public static void main(String args[]) {
        PrisonCellsAfterNDays pcand = new PrisonCellsAfterNDays();
        int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(pcand.prisonAfterNDays(cells, 7)));
    }
}
