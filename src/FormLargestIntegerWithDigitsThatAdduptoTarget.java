
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FormLargestIntegerWithDigitsThatAdduptoTarget {

    public String largestNumber(int[] cost, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 1; i <= 9; i++) {
            map.put(cost[i - 1], Math.max(map.getOrDefault(cost[i - 1], 0), i));
        }
        Arrays.sort(cost);
        List<List<String>> result = new ArrayList();
        permutation(result, new ArrayList(), cost, target, map);
        //System.out.println(result);
        Long max = Long.MIN_VALUE;
        for (List<String> l : result) {
            int size = l.size();
            long local = 0;
            for (int i = size - 1; i >= 0; i--) {
                local = local * 10 + Long.parseLong(l.get(i));
            }
            max = Math.max(max, local);
        }
        if (max == Long.MIN_VALUE) {
            return "0";
        }
        return "" + max;
    }

    public void permutation(List<List<String>> result, ArrayList<String> path, int[] cost, int target, HashMap<Integer, Integer> map) {
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
                if (i != 0 && cost[i] == cost[i - 1]) {
                    continue;
                }
                path.add("" + (map.get(cost[i])));
                permutation(result, path, cost, target - cost[i], map);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        FormLargestIntegerWithDigitsThatAdduptoTarget fliwdtat = new FormLargestIntegerWithDigitsThatAdduptoTarget();
//        int[] arr = new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5};
//        System.out.println(fliwdtat.largestNumber(arr, 9));
//        int[] arr = new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40};
//        System.out.println(fliwdtat.largestNumber(arr, 47));
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 3, 2};
        System.out.println(fliwdtat.largestNumber(arr, 10));
    }
}
