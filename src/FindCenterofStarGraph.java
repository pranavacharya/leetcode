
public class FindCenterofStarGraph {

    public int findCenter(int[][] edges) {
        int[] indegree = new int[edges.length + 2];

        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        int center = -1;
        int max = 0;
        for (int i = 1; i < indegree.length; i++) {
            if (max < indegree[i]) {
                center = i;
                max = indegree[i];
            }
        }

        return center;
    }

    public static void main(String[] args) {
        FindCenterofStarGraph fcsg = new FindCenterofStarGraph();
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {4, 2}};
        System.out.println(fcsg.findCenter(edges));
    }
}
