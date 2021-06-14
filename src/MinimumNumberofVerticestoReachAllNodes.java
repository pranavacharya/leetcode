
import java.util.ArrayList;
import java.util.List;

public class MinimumNumberofVerticestoReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            indegree[edge.get(1)]++;
        }
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        MinimumNumberofVerticestoReachAllNodes mnvtran = new MinimumNumberofVerticestoReachAllNodes();
        List<List<Integer>> edges = new ArrayList();
        List<Integer> first = new ArrayList();
        List<Integer> second = new ArrayList();
        List<Integer> third = new ArrayList();
        List<Integer> fourth = new ArrayList();
        List<Integer> fifth = new ArrayList();
        first.add(0);
        first.add(1);
        second.add(0);
        second.add(2);
        third.add(2);
        third.add(5);
        fourth.add(3);
        fourth.add(4);
        fifth.add(4);
        fifth.add(2);
        edges.add(first);
        edges.add(second);
        edges.add(third);
        edges.add(fourth);
        edges.add(fifth);
        System.out.println(mnvtran.findSmallestSetOfVertices(6, edges));
    }
}
