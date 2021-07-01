
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class NumberofNodesintheSubTreeWiththeSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet();
        int[] ans = new int[n];
        int[] freq = helper(adj, 0, labels, ans, visited);
        ans[0] = freq[labels.charAt(0) - 'a'];
        return ans;
    }

    private int[] helper(HashMap<Integer, ArrayList<Integer>> adj, int node, String labels, int[] ans, HashSet<Integer> visited) {
        visited.add(node);
        int[] freq = new int[26];
        ArrayList<Integer> neighbours = adj.get(node);
        freq[labels.charAt(node) - 'a']++;
        for (int neighbour : neighbours) {
            if (visited.contains(neighbour)) {
                continue;
            }
            int[] temp = helper(adj, neighbour, labels, ans, visited);
            for (int i = 0; i < temp.length; i++) {
                freq[i] += temp[i];
            }
        }
        ans[node] = freq[labels.charAt(node) - 'a'];
        return freq;
    }

    public static void main(String[] args) {
        NumberofNodesintheSubTreeWiththeSameLabel nnstwsl = new NumberofNodesintheSubTreeWiththeSameLabel();
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        System.out.println(Arrays.toString(nnstwsl.countSubTrees(7, edges, "abaedcd")));
    }
}
