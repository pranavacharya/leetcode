
import java.util.Arrays;
import java.util.HashMap;

public class RedundantConnection {

    private HashMap<Integer, Integer> map;

    public int[] findRedundantConnection(int[][] edges) {
        this.map = new HashMap();
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            } else {
                union(edge[0], edge[1]);
            }
        }
        return new int[]{-1, -1};
    }

    private int find(int x) {
        while (this.map.containsKey(x) && this.map.get(x) != x) {
            x = this.map.get(x);
        }
        if (!this.map.containsKey(x)) {
            this.map.put(x, x);
        }
        return this.map.get(x);
    }

    private void union(int x, int y) {
        int x1 = find(x);
        int y1 = find(y);
        this.map.put(y1, x1);
    }

    public static void main(String args[]) {
        RedundantConnection rc = new RedundantConnection();
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(rc.findRedundantConnection(edges)));
    }
}
