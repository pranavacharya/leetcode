
public class BeautifulArrangement {

    private int arrangement = 0;

    public int countArrangement(int n) {
        backTracking(1, n, new boolean[n + 1]);
        return this.arrangement;
    }

    private void backTracking(int i, int n, boolean[] visited) {
        if (i == n + 1) {
            boolean status = true;
            for (int j = 1; j < visited.length; j++) {
                status = status & visited[j];
            }
            if (status) {
                this.arrangement++;
            }
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (visited[j] || !(j % i == 0 || i % j == 0)) {
                continue;
            }
            visited[j] = true;
            backTracking(i + 1, n, visited);
            visited[j] = false;
        }
    }

    public static void main(String args[]) {
        BeautifulArrangement ba = new BeautifulArrangement();
        System.out.println(ba.countArrangement(15));
    }
}
