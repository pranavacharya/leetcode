
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String newStr = new String(arr);
            map.putIfAbsent(newStr, new ArrayList());
            map.get(newStr).add(str);
        }
        List<List<String>> result = new ArrayList();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String args[]) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(strs));
    }
}
