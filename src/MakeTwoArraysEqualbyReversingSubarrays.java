
import java.util.HashMap;

public class MakeTwoArraysEqualbyReversingSubarrays {

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        HashMap<Integer, Integer> targetMap = new HashMap();
        HashMap<Integer, Integer> arrMap = new HashMap();
        for (int i = 0; i < target.length; i++) {
            targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int k : targetMap.keySet()) {
            if (!arrMap.containsKey(k)) {
                return false;
            } else {
                if (targetMap.get(k) != arrMap.get(k)) {
                    return false;
                }
            }
        }
        for (int k : arrMap.keySet()) {
            if (!targetMap.containsKey(k)) {
                return false;
            } else {
                if (targetMap.get(k) != arrMap.get(k)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        MakeTwoArraysEqualbyReversingSubarrays mtaers = new MakeTwoArraysEqualbyReversingSubarrays();
        int[] target = new int[]{};
        int[] arr = new int[]{};
        System.out.println(mtaers.canBeEqual(target, arr));
    }
}
