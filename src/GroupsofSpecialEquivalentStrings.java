
import java.util.Arrays;
import java.util.HashSet;

public class GroupsofSpecialEquivalentStrings {

    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet();
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            char[] even = new char[(s.length() + 1) / 2];
            char[] odd = new char[s.length() / 2];
            int eindex = 0;
            int oindex = 0;
            for (int j = 0; j < s.length(); j++) {
                if (j % 2 == 0) {
                    even[eindex++] = s.charAt(j);
                } else {
                    odd[oindex++] = s.charAt(j);
                }
            }
            Arrays.sort(even);
            Arrays.sort(odd);
            char[] sorted = new char[s.length()];
            int index = 0;
            for (int j = 0; j < even.length; j++) {
                sorted[index] = even[j];
                index += 2;
            }
            index = 1;
            for (int j = 0; j < odd.length; j++) {
                sorted[index] = odd[j];
                index += 2;
            }
            set.add(new String(sorted));
        }
        return set.size();
    }

    public static void main(String[] args) {
        GroupsofSpecialEquivalentStrings gses = new GroupsofSpecialEquivalentStrings();
        String[] A = new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
        System.out.println(gses.numSpecialEquivGroups(A));
    }
}
