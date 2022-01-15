
public class CouplesHoldingHands {

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] graph = new int[n];
        for (int i = 0; i < row.length; i += 2) {
            graph[row[i]] = row[i + 1];
            graph[row[i + 1]] = row[i];
        }
        int count = 0;
        for (int i = 0; i < row.length; i += 2) {
            if (graph[i] != i + 1) {
                count += dfs(graph, i, i + 1);
            }
        }
        return count;
    }

    private int dfs(int[] graph, int index, int curr) {
        int count = 1;

        // assign
        int prev = graph[index];
        graph[index] = curr;
        int prevCurr = graph[curr];
        graph[curr] = index;

        graph[prev] = prevCurr;
        graph[prevCurr] = prev;

        if (prev % 2 == 0) {
            if (graph[prev] != prev + 1) {
                count += dfs(graph, prev, prev + 1);
            }
        } else {
            if (graph[prev] != prev - 1) {
                count += dfs(graph, prev, prev - 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CouplesHoldingHands chh = new CouplesHoldingHands();
        int[] row = new int[]{0, 3, 1, 4, 2, 6, 5, 7};
        System.out.println(chh.minSwapsCouples(row));
    }
}
