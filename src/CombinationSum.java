
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList(), candidates, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, ArrayList<Integer> path, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList(path));
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                path.add(candidates[i]);
                backtrack(result, path, candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(cs.combinationSum(candidates, 7));
    }
}
