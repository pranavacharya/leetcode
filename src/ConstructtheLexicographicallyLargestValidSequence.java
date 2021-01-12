
import java.util.Arrays;
import java.util.HashSet;

public class ConstructtheLexicographicallyLargestValidSequence {

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        backtrack(ans, n, 0, new HashSet());
        return ans;
    }

    private boolean backtrack(int[] ans, int n, int index, HashSet<Integer> visited) {
        if (index == ans.length) {
            return true;
        }
        if (ans[index] != 0) {
            return backtrack(ans, n, index + 1, visited);
        }
        for (int i = n; i >= 1; i--) {
            if (visited.contains(i)) {
                continue;
            }
            if (i == 1) {
                if (ans[index] == 0) {
                    ans[index] = i;
                    visited.add(i);
                    if (backtrack(ans, n, index + 1, visited)) {
                        return true;
                    }
                    ans[index] = 0;
                    visited.remove(i);
                }
            } else {
                if (index + i < ans.length) {
                    if (ans[index] == 0 && ans[index + i] == 0) {
                        ans[index] = i;
                        ans[index + i] = i;
                        visited.add(i);
                        if (backtrack(ans, n, index + 1, visited)) {
                            return true;
                        }
                        ans[index] = 0;
                        ans[index + i] = 0;
                        visited.remove(i);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ConstructtheLexicographicallyLargestValidSequence cllvs = new ConstructtheLexicographicallyLargestValidSequence();
        System.out.println(Arrays.toString(cllvs.constructDistancedSequence(7)));
    }
}
