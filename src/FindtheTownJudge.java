
public class FindtheTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[1001];
        int[] outdegree = new int[1001];
        for (int i = 0; i < trust.length; i++) {
            outdegree[trust[i][0]]++;
            indegree[trust[i][1]]++;
        }
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        FindtheTownJudge fttj = new FindtheTownJudge();
        int[][] trust = new int[][]{{1, 2}, {2, 3}};
        System.out.println(fttj.findJudge(3, trust));
    }
}
