
import java.util.Arrays;
import java.util.HashSet;

public class ConstructtheLexicographicallyLargestValidSequence {

    private int[] res;

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        this.res = new int[2 * n - 1];
        backtrack(ans, n, new HashSet());
        return this.res;
    }

    private void backtrack(int[] ans, int n, HashSet<Integer> visited) {
        if (visited.size() == n) {
            if (isGreater(this.res, ans)) {
                for (int i = 0; i < ans.length; i++) {
                    this.res[i] = ans[i];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            for (int j = 0; j < ans.length; j++) {
                if (ans[j] != 0) {
                    continue;
                }
                if (i == 1) {
                    if (ans[j] == 0) {
                        ans[j] = i;
                        visited.add(i);
                        backtrack(ans, n, visited);
                        ans[j] = 0;
                        visited.remove(i);
                    }
                } else {
                    if (j + i < ans.length) {
                        if (ans[j] == 0 && ans[j + i] == 0) {
                            ans[j] = i;
                            ans[j + i] = i;
                            visited.add(i);
                            backtrack(ans, n, visited);
                            ans[j] = 0;
                            ans[j + i] = 0;
                            visited.remove(i);
                        }
                    }
                }
            }
        }
    }

    private boolean isGreater(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            } else {
                if (arr1[i] > arr2[i]) {
                    return false;
                } else {
                    return true;
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
