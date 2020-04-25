
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        ArrayList<String> list = new ArrayList<>();
        if (A.length == 0) {
            return list;
        }
        HashMap<Character, Integer> common = new HashMap<>();
        for (char c : A[0].toCharArray()) {
            common.put(c, common.getOrDefault(c, 0) + 1);
        }
        for (int i = 1; i < A.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char c : A[i].toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }
            for (char c : common.keySet()) {
                if (temp.containsKey(c)) {
                    if (temp.get(c) < common.get(c)) {
                        common.put(c, temp.get(c));
                    }
                } else {
                    common.put(c, -1);
                }
            }
        }
        for (char c : common.keySet()) {
            String letter = "" + c;
            int count = common.get(c);
            while (count > 0) {
                list.add(letter);
                count--;
            }
        }
        return list;
    }

    public static void main(String args[]) {
        FindCommonCharacters fcc = new FindCommonCharacters();
        String[] A = new String[]{"cool", "lock", "cook"};
        System.out.println(fcc.commonChars(A));
    }
}
