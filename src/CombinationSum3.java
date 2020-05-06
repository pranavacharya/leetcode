
import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        backtracking(result, new ArrayList(), k, n, 1);
        return result;
    }

    public void backtracking(List<List<Integer>> result, ArrayList<Integer> path, int k, int target, int index) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList(path));
        } else if (target < 0 || k < 0) {
            return;
        } else {
            for (int i = index; i <= target && i <= 9; i++) {
                path.add(i);
                backtracking(result, path, k - 1, target - i, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        CombinationSum3 cs3 = new CombinationSum3();
        System.out.println(cs3.combinationSum3(3, 9));
        System.out.println(cs3.combinationSum3(2, 18));
    }
}
