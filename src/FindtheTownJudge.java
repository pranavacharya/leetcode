
public class FindtheTownJudge {

    public int findJudge(int N, int[][] trust) {
        int[] trustedBy = new int[N];
        int[] trusts = new int[N];
        for (int[] t : trust) {
            trustedBy[t[1] - 1]++;
            trusts[t[0] - 1]++;
        }

        for (int i = 0; i < N; i++) {
            if (trustedBy[i] == N - 1 && trusts[i] == 0) {
                return i + 1;
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
