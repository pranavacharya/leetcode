
import java.util.HashMap;
import java.util.HashSet;

public class FindtheTownJudge {

    public int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> map = new HashMap();
        HashSet<Integer> set = new HashSet();
        for (int i = 1; i <= N; i++) {
            map.put(i, 0);
            set.add(i);
        }
        for (int[] t : trust) {
            if (set.contains(t[0])) {
                set.remove(t[0]);
            }
            map.put(t[1], map.get(t[1]) + 1);
        }
        if (set.isEmpty()) {
            return -1;
        } else {
            for (int s : set) {
                if (map.get(s) == N - 1) {
                    return s;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        FindtheTownJudge fttj = new FindtheTownJudge();
        int[][] trust = new int[][]{{1, 2}, {2, 3}};
        System.out.println(fttj.findJudge(3, trust));
    }
}
