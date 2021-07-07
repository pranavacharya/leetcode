
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        helper(candidates, target, 0, new ArrayList(), list);
        return list;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> result) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList(path));
            }
            return;
        }
        if (candidates[index] <= target) {
            path.add(candidates[index]);
            helper(candidates, target - candidates[index], index, path, result);
            path.remove(path.size() - 1);
        }
        helper(candidates, target, index + 1, path, result);

    }

    public static void main(String args[]) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(cs.combinationSum(candidates, 7));
    }
}
