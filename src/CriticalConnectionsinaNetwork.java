
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class CriticalConnectionsinaNetwork {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList();
        set = new HashSet();
        HashMap<Integer, List<Integer>> adj = new HashMap();
        for (List<Integer> connect : connections) {
            Collections.sort(connect);
            set.add("" + connect.get(0) + " " + connect.get(1));

            // add edge to adj graph
            adj.putIfAbsent(connect.get(0), new ArrayList());
            adj.putIfAbsent(connect.get(1), new ArrayList());
            adj.get(connect.get(1)).add(connect.get(0));
            adj.get(connect.get(0)).add(connect.get(1));
        }

        this.nodeRank = new int[n + 1];
        Arrays.fill(nodeRank, -2);

        dfs(0, 0, adj);

        for (String item : set) {
            List<Integer> temp = new ArrayList();
            temp.add(Integer.parseInt(item.split(" ")[0]));
            temp.add(Integer.parseInt(item.split(" ")[1]));
            result.add(temp);
        }
        return result;
    }

    private int[] nodeRank;
    private HashSet<String> set;

    private int dfs(int node, int rank, HashMap<Integer, List<Integer>> adj) {

        if (nodeRank[node] != -2) {
            return nodeRank[node];
        }

        nodeRank[node] = rank;

        int min = rank + 1;
        List<Integer> neighbours = adj.get(node);

        for (int neighbour : neighbours) {
            // parent
            if (nodeRank[neighbour] == rank - 1) {
                continue;
            }

            int neighbourRank = dfs(neighbour, rank + 1, adj);

            // cycle found
            if (neighbourRank <= rank) {
                if (neighbour < node) {
                    set.remove("" + neighbour + " " + node);
                } else {
                    set.remove("" + node + " " + neighbour);
                }
            }
            min = Math.min(min, neighbourRank);
        }
        return min;
    }
    
    public static void main(String[] args) {
        CriticalConnectionsinaNetwork ccin = new CriticalConnectionsinaNetwork();
        List<List<Integer>> connections = new ArrayList();
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        List<Integer> list3 = new ArrayList();
        List<Integer> list4 = new ArrayList();
        list1.add(0);
        list1.add(1);
        list2.add(1);
        list2.add(2);
        list3.add(2);
        list3.add(0);
        list4.add(1);
        list4.add(3);
        connections.add(list1);
        connections.add(list2);
        connections.add(list3);
        connections.add(list4);
        System.out.println(ccin.criticalConnections(4, connections));
    }
}
