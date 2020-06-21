
import java.util.Arrays;
import java.util.HashMap;

public class MakingFileNamesUnique {

    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap();
        String[] result = new String[names.length];
        int i = 0;
        for (String name : names) {
            if (map.containsKey(name)) {
                int j = 1;
                while (map.containsKey(name + "(" + j + ")")) {
                    j++;
                }
                map.put(name + "(" + j + ")", j);
                result[i] = name + "(" + j + ")";
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
