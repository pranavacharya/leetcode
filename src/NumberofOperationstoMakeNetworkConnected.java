
import java.util.HashMap;
import java.util.HashSet;

public class NumberofOperationstoMakeNetworkConnected {

    private int count;

    public int makeConnected(int n, int[][] connections) {
        this.count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < connections.length; i++) {
            union(connections[i][0], connections[i][1], map);
        }
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            set.add(find(i, map));
        }
        if (this.count >= set.size() - 1) {
            return set.size() - 1;
        } else {
            return - 1;
        }
    }

    private void union(int x, int y, HashMap<Integer, Integer> map) {
        int xp = find(x, map);
        int yp = find(y, map);
        if (xp != yp) {
            if (yp > xp) {
                map.put(yp, xp);
            } else {
                map.put(xp, yp);
            }
        } else {
            this.count++;
        }
    }

    private int find(int x, HashMap<Integer, Integer> map) {
        if (map.containsKey(x)) {
            while (map.get(x) != x) {
                x = map.get(x);
            }
            return x;
        } else {
            map.put(x, x);
            return x;
        }
    }

    public static void main(String args[]) {
        NumberofOperationstoMakeNetworkConnected nomnc = new NumberofOperationstoMakeNetworkConnected();
        int[][] connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(nomnc.makeConnected(6, connections));
    }
}
