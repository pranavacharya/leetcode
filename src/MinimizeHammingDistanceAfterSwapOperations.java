
import java.util.HashMap;

public class MinimizeHammingDistanceAfterSwapOperations {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < allowedSwaps.length; i++) {
            int s = allowedSwaps[i][0];
            int t = allowedSwaps[i][1];
            union(s, t, map);
        }
        HashMap<Integer, HashMap<Integer, Integer>> freq = new HashMap();
        for (int i = 0; i < source.length; i++) {
            int val = source[i];
            int parent = find(i, map);
            freq.putIfAbsent(parent, new HashMap());
            HashMap<Integer, Integer> freqCount = freq.get(parent);
            freqCount.put(val, freqCount.getOrDefault(val, 0) + 1);
        }
        int minDistnace = 0;
        for (int i = 0; i < target.length; i++) {
            int val = target[i];
            int parent = find(i, map);
            HashMap<Integer, Integer> freqCount = freq.get(parent);
            if (freqCount.getOrDefault(val, 0) == 0) {
                minDistnace++;
            } else {
                freqCount.put(val, freqCount.get(val) - 1);
            }
        }

        return minDistnace;
    }

    private int find(int target, HashMap<Integer, Integer> map) {
        while (map.containsKey(target)) {
            if (target == map.get(target)) {
                break;
            }
            target = map.get(target);
        }
        map.put(target, target);
        return map.get(target);
    }

    private void union(int x, int y, HashMap<Integer, Integer> map) {
        int xp = find(x, map);
        int yp = find(y, map);
        map.put(xp, yp);
    }

    public static void main(String args[]) {
        MinimizeHammingDistanceAfterSwapOperations mhdas = new MinimizeHammingDistanceAfterSwapOperations();
        int[] source = new int[]{1, 2, 3, 4};
        int[] target = new int[]{2, 1, 4, 5};
        int[][] allowedSwaps = new int[][]{{0, 1}, {2, 3}};
        System.out.println(mhdas.minimumHammingDistance(source, target, allowedSwaps));
    }
}
