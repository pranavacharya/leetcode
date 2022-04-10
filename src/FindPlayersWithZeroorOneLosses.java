
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindPlayersWithZeroorOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, Integer> freq = new HashMap();
        int max = 0;
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < matches.length; i++) {
            int[] match = matches[i];
            set.add(match[0]);
            set.add(match[1]);
            freq.put(match[1], freq.getOrDefault(match[1], 0) + 1);
            max = Math.max(max, match[0]);
            max = Math.max(max, match[1]);
        }
        List<Integer> notlost = new ArrayList();
        List<Integer> onelost = new ArrayList();
        for (int i = 0; i <= max; i++) {
            if(set.contains(i)) {
                if(freq.getOrDefault(i, 0) == 0) {
                    notlost.add(i);
                } else if(freq.get(i) == 1) {
                    onelost.add(i);
                }
            }
        }
        result.add(notlost);
        result.add(onelost);
        return result;
    }

    public static void main(String[] args) {
        FindPlayersWithZeroorOneLosses fpwzol = new FindPlayersWithZeroorOneLosses();
        int[][] matches = new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(fpwzol.findWinners(matches));
    }
}
