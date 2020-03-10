
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (map.containsKey(sorted)) {
                List<String> templist = map.get(sorted);
                templist.add(str);
                map.put(sorted, templist);
            } else {
                List<String> templist = new ArrayList<>();
                templist.add(str);
                map.put(sorted, templist);
            }
        }
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }

    public static void main(String args[]) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(strs));
    }
}
