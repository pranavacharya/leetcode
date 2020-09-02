
import java.util.HashMap;
import java.util.HashSet;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    union(i, j, map);
                }
            }
        }
        HashSet<Integer> set = new HashSet();
        for (int key : map.keySet()) {
            set.add(find(map, key));
        }
        return set.size();
    }

    private void union(int x, int y, HashMap<Integer, Integer> map) {
        int x1 = find(map, x);
        int y1 = find(map, y);
        if (x1 != y1) {
            map.put(x1, y1);
        }
    }

    private int find(HashMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            while (map.get(key) != key) {
                key = map.get(key);
            }
            return key;
        } else {
            map.put(key, key);
            return key;
        }
    }

    public static void main(String args[]) {
        FriendCircles fc = new FriendCircles();
//        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(fc.findCircleNum(M));
    }
}
