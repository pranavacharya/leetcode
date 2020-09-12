
import java.util.HashMap;

public class NRepeatedElementinSize2NArray {

    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == A.length / 2) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        NRepeatedElementinSize2NArray nres2n = new NRepeatedElementinSize2NArray();
        int[] A = new int[]{2, 1, 2, 5, 3, 2};
        System.out.println(nres2n.repeatedNTimes(A));
    }
}
