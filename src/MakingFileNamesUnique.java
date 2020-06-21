
import java.util.Arrays;
import java.util.HashMap;

public class MakingFileNamesUnique {

    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap();
        String[] result = new String[names.length];
        int i = 0;
        for (String name : names) {
            if (map.containsKey(name)) {
                StringBuilder sb = new StringBuilder(name);
                int val = map.get(name);
                sb.append("(");
                sb.append(val);
                sb.append(")");
                while (map.containsKey(sb.toString())) {
                    val++;
                    sb = new StringBuilder(name);
                    sb.append("(");
                    sb.append(val);
                    sb.append(")");
                }
                map.put(sb.toString(), 1);
                map.put(name, val + 1);
                result[i] = sb.toString();
            } else {
                map.put(name, 1);
                result[i] = name;
            }
            i++;
        }
        return result;
    }

    public static void main(String args[]) {
        MakingFileNamesUnique mfnu = new MakingFileNamesUnique();
        String[] names = new String[]{
            "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        System.out.println(Arrays.toString(mfnu.getFolderNames(names)));
    }
}
