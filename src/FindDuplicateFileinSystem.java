
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileinSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap();

        for (String path : paths) {
            String[] splits = path.split(" ");
            for (int i = 1; i < splits.length; i++) {
                String content = splits[i].substring(splits[i].lastIndexOf("("), splits[i].length() - 1);
                map.putIfAbsent(content, new ArrayList());
                String filePath = splits[0] + "/" + splits[i].substring(0, splits[i].lastIndexOf("("));
                map.get(content).add(filePath);
            }
        }

        List<List<String>> result = new ArrayList();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(map.get(key));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDuplicateFileinSystem fdfs = new FindDuplicateFileinSystem();
        String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(fdfs.findDuplicate(paths));
    }
}
