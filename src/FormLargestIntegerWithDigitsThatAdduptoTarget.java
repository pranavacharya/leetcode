
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormLargestIntegerWithDigitsThatAdduptoTarget {

    public String largestNumber(int[] cost, int target) {
        List<List<String>> result = new ArrayList();
        permutation(result, new ArrayList(), cost, target);
        int max = Integer.MIN_VALUE;
        for (List<String> l : result) {
            int size = l.size();
            int local = 0;
            for (int i = size - 1; i >= 0; i--) {
                local = local * 10 + Integer.parseInt(l.get(i));
            }
            max = Math.max(max, local);
        }
        if (max == Integer.MIN_VALUE) {
            return "0";
        }
        return "" + max;
    }

    public void permutation(List<List<String>> result, ArrayList<String> path, int[] cost, int target) {
        if (target == 0) {
            ArrayList<String> temp = new ArrayList(path);
            Collections.sort(temp);
            if (!result.contains(temp)) {
                result.add(temp);
            }
        } else if (target < 0) {
            return;
        } else {
            for (int i = 0; i < cost.length; i++) {
                path.add("" + (i + 1));
                permutation(result, path, cost, target - cost[i]);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        FormLargestIntegerWithDigitsThatAdduptoTarget fliwdtat = new FormLargestIntegerWithDigitsThatAdduptoTarget();
//        int[] arr = new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5};
//        System.out.println(fliwdtat.largestNumber(arr, 9));
        int[] arr = new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40};
        System.out.println(fliwdtat.largestNumber(arr, 47));
    }
}
