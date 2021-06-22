
import java.util.ArrayList;
import java.util.HashMap;

public class NumberofMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        // init map
        for (int i = 0; i < 26; i++) {
            map.put(i, new ArrayList());
        }
        int index = 0;
        for (char c : s.toCharArray()) {
            map.get(c - 'a').add(index++);
        }

        int count = 0;
        for (String word : words) {
            int last = -1;
            boolean isWordPresent = true;
            for (char c : word.toCharArray()) {
                boolean flag = false;
                ArrayList<Integer> list = map.get(c - 'a');
                for (int i = 0; i < list.size(); i++) {
                    if (last < list.get(i)) {
                        flag = true;
                        last = list.get(i);
                        break;
                    }
                }
                if (!flag) {
                    isWordPresent = false;
                    break;
                }
            }
            if (isWordPresent) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberofMatchingSubsequences noms = new NumberofMatchingSubsequences();
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        System.out.println(noms.numMatchingSubseq("abcde", words));
    }
}
