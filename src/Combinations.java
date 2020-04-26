
import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        combination(n, 1, k, new ArrayList(), list);
        return list;
    }

    public void combination(int n, int index, int k, ArrayList<Integer> path, List<List<Integer>> list) {
        if (k == 0 && !list.contains(path)) {
            list.add(path);
        } else {
            for (int i = index; i <= n; i++) {
                path.add(i);
                combination(n, i + 1, k - 1, new ArrayList(path), list);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }
}
