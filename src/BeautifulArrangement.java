
import java.util.ArrayList;

public class BeautifulArrangement {

    private int count;

    public BeautifulArrangement() {
        this.count = 0;
    }

    public int countArrangement(int N) {
        backtracking(N, 1, new ArrayList(), new boolean[N + 1]);
        return this.count;
    }

    public void backtracking(int n, int pos, ArrayList<Integer> path, boolean[] used) {
        if (pos > n) {
            //System.out.println(path);
            this.count++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (used[i]) {
                    continue;
                }
                if ((pos % i == 0 || i % pos == 0)) {
                    path.add(i);
                    used[i] = true;
                    backtracking(n, pos + 1, path, used);
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String args[]) {
        BeautifulArrangement ba = new BeautifulArrangement();
        System.out.println(ba.countArrangement(14));
    }
}
