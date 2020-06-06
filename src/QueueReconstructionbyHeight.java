
import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        ArrayList<int[]> result = new ArrayList();
        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1], people[i]);
        }
        return result.toArray(people);
    }

    public static void main(String args[]) {
        QueueReconstructionbyHeight qrbh = new QueueReconstructionbyHeight();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(qrbh.reconstructQueue(people)));
    }
}
