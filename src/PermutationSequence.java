
import java.util.ArrayList;

public class PermutationSequence {

    private int count;
    private String ans;

    public PermutationSequence() {
        this.count = 0;
        this.ans = "";
    }

    public String getPermutation(int n, int k) {
        this.count = k;
        boolean[] visited = new boolean[n + 1];
        backtracking(new ArrayList(), n, visited);
        return this.ans;
    }

    public boolean backtracking(ArrayList<Integer> path, int n, boolean[] visited) {
        if (path.size() == n) {
            this.count--;
            if (this.count == 0) {
                StringBuilder sb = new StringBuilder();
                for (int element : path) {
                    sb = sb.append(element);
                }
                this.ans = sb.toString();
                return true;
            }
            return false;
        } else {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                path.add(i);
                visited[i] = true;
                if (backtracking(path, n, visited)) {
                    return true;
                }
                path.remove(path.size() - 1);
                visited[i] = false;
            }
            return false;
        }
    }

    public static void main(String args[]) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(3, 3));
        System.out.println(ps.getPermutation(4, 9));
    }
}
