
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList();
        HashSet<Integer> visited = new HashSet();
        ans.add(0);
        visited.add(0);
        dfs(0, n, -1, ans, visited);
        return ans;
    }

    private void dfs(int mask, int length, int index, List<Integer> list, HashSet<Integer> visited) {
        for (int i = 0; i < length; i++) {
            if (i == index) {
                continue;
            }
            int next = mask ^ (1 << i);
            if (!visited.contains(next)) {
                list.add(next);
                visited.add(next);
                dfs(next, length, i, list, visited);
            }
        }
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(2));
    }
}
