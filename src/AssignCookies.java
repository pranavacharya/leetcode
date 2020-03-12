
import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        AssignCookies ac = new AssignCookies();
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        System.out.println(ac.findContentChildren(g, s));
    }
}
