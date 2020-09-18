
import java.util.Arrays;
import java.util.HashMap;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            if (find(map, edges[i][0]) == find(map, edges[i][1])) {
                return edges[i];
            } else {
                union(map, edges[i][0], edges[i][1]);
            }
        }
        return new int[]{-1, -1};
    }

    private void union(HashMap<Integer, Integer> map, int x, int y) {
        int xp = find(map, x);
        int yp = find(map, y);
        if (xp != yp) {
            map.put(xp, yp);
        }
    }

    private int find(HashMap<Integer, Integer> map, int x) {
        if (map.containsKey(x)) {
            while (map.get(x) != x) {
                x = map.get(x);
            }
            return map.get(x);
        } else {
            map.put(x, x);
            return x;
        }
    }

    public static void main(String args[]) {
        RedundantConnection rc = new RedundantConnection();
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(rc.findRedundantConnection(edges)));
    }
}
