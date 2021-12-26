
import java.util.Arrays;
import java.util.HashMap;

public class IntervalsBetweenIdenticalElements {

    public long[] getDistances(int[] arr) {
        long[] ans = new long[arr.length];
        HashMap<Integer, int[]> lastPos = new HashMap();
        long[] prefix = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (lastPos.containsKey(arr[i])) {
                int[] last = lastPos.get(arr[i]);
                prefix[i] = prefix[last[0]] + (i - last[0]) * last[1];
            } else {
                prefix[i] = 0;
            }
            int[] last = lastPos.getOrDefault(arr[i], new int[]{-1, 0});
            lastPos.put(arr[i], new int[]{i, last[1] + 1});
        }

        long[] suffix = new long[arr.length];
        lastPos.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (lastPos.containsKey(arr[i])) {
                int[] last = lastPos.get(arr[i]);
                suffix[i] = suffix[last[0]] + (last[0] - i) * last[1];
            } else {
                suffix[i] = 0;
            }
            int[] last = lastPos.getOrDefault(arr[i], new int[]{-1, 0});
            lastPos.put(arr[i], new int[]{i, last[1] + 1});
        }
        for (int i = 0; i < prefix.length; i++) {
            ans[i] = prefix[i] + suffix[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        IntervalsBetweenIdenticalElements ibie = new IntervalsBetweenIdenticalElements();
        int[] arr = new int[]{2, 1, 3, 1, 2, 3, 3};
        System.out.println(Arrays.toString(ibie.getDistances(arr)));
    }
}
