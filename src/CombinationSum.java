
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        subset(candidates, 0, new ArrayList(), result, target);
        return result;
    }

    public void subset(int[] arr, int index, ArrayList<Integer> path, List<List<Integer>> result, int target) {
        if (target == 0) {
            Collections.sort(path);
            if (!result.contains(path)) {
                result.add(path);
            }
        } else if (index == arr.length || target < 0) {
            return;
        } else {
            for (int i = index; i < arr.length; i++) {
                path.add(arr[i]);
                subset(arr, i, new ArrayList(path), result, target - arr[i]);
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
