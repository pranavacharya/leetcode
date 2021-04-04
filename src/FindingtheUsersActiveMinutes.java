
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindingtheUsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> freq = new HashMap();
        int[] result = new int[k];

        for (int i = 0; i < logs.length; i++) {
            int[] log = logs[i];
            freq.putIfAbsent(log[0], new HashSet());
            freq.get(log[0]).add(log[1]);
        }

        for (int key : freq.keySet()) {
            HashSet<Integer> set = freq.get(key);
            result[set.size() - 1]++;
        }
        return result;
    }

    public static void main(String[] args) {
        FindingtheUsersActiveMinutes ftuam = new FindingtheUsersActiveMinutes();
        int[][] logs = new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        System.out.println(Arrays.toString(ftuam.findingUsersActiveMinutes(logs, 5)));
    }
}
