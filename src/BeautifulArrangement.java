
import java.util.ArrayList;

public class BeautifulArrangement {

    private int count;

    public BeautifulArrangement() {
        this.count = 0;
    }

    public int countArrangement(int N) {
        backtracking(N, new ArrayList(), new boolean[N + 1]);
        return this.count;
    }

    public void backtracking(int n, ArrayList<Integer> path, boolean[] used) {
        if (n == path.size()) {
            if (isBeautifulArrangement(path)) {
                System.out.println(path);
                this.count++;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(i);
                used[i] = true;
                backtracking(n, path, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isBeautifulArrangement(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) % (i + 1) != 0 && (i + 1) % path.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        BeautifulArrangement ba = new BeautifulArrangement();
        System.out.println(ba.countArrangement(2));
    }
}
