
import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                List<Integer> sublist = new ArrayList();
                sublist.add(i);
                sublist.add(j - 1);
                result.add(sublist);
            }
            i = j;
        }
        return result;
    }

    public static void main(String args[]) {
        PositionsofLargeGroups plg = new PositionsofLargeGroups();
        System.out.println(plg.largeGroupPositions("abbxxxxzzy"));
        System.out.println(plg.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(plg.largeGroupPositions("aba"));
        System.out.println(plg.largeGroupPositions("abc"));
    }
}
