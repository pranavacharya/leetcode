
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backtracking(result, new ArrayList(), candidates, target, 0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, ArrayList<Integer> path, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList(path));
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i != index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                backtracking(result, path, candidates, target - candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        CombinationSum2 cs2 = new CombinationSum2();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(cs2.combinationSum2(candidates, 8));
    }
}
