
import java.util.Arrays;

public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        for (int i = 0; i < N; i++) {
            int[] temp = new int[cells.length];
            for (int j = 1; j < 7; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    temp[j] = 1;
                } else {
                    temp[j] = 0;
                }
            }
            temp[0] = 0;
            temp[7] = 0;
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
