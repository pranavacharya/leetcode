
import java.util.ArrayList;
import java.util.Arrays;

public class QueriesonaPermutationWithKey {

    public int[] processQueries(int[] queries, int m) {
        ArrayList<Integer> P = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            P.add(i);
        }
        int[] ans = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int index = -1;
            for (int i = 0; i < P.size(); i++) {
                if (P.get(i) == queries[j]) {
                    index = i;
                    break;
                }
            }
            ans[j] = index;
            P.remove(index);
            P.add(0, queries[j]);
        }
        return ans;
    }

    public static void main(String args[]) {
        QueriesonaPermutationWithKey qopwk = new QueriesonaPermutationWithKey();
        int[] queries = new int[]{3, 1, 2, 1};
        System.out.println(Arrays.toString(qopwk.processQueries(queries, 5)));
    }
}
