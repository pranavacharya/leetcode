
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            map.putIfAbsent(new String(arr), new ArrayList());
            map.get(new String(arr)).add(str);
        }
        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    public static void main(String args[]) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(strs));
    }
}
