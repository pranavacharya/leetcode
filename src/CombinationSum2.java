
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combination(candidates, 0, 0, new ArrayList<>(), target);
        return this.result;
    }

    public void combination(int[] candidates, int pos, int sum, ArrayList paths, int target) {
        if (sum == target) {
            Collections.sort(paths);
            if (!result.contains(paths)) {
                this.result.add(paths);
            }
        } else if (candidates.length == pos) {
            return;
        } else {
            paths.add(candidates[pos]);
            combination(candidates, pos + 1, sum + candidates[pos], new ArrayList(paths), target);
            paths.remove(paths.size() - 1);
            combination(candidates, pos + 1, sum, new ArrayList(paths), target);
        }
    }

    public static void main(String args[]) {
        CombinationSum2 cs2 = new CombinationSum2();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(cs2.combinationSum2(candidates, 8));
    }
}
