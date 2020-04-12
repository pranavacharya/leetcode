
import java.util.ArrayList;
import java.util.List;

public class StringMatchinginanArray {

    public List<String> stringMatching(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].contains(words[j]) && i != j && !list.contains(words[j])) {
                    list.add(words[j]);
                }
            }
        }
        return list;
    }

    public static void main(String args[]) {
        StringMatchinginanArray sma = new StringMatchinginanArray();
        String[] words = new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"};
        System.out.println(sma.stringMatching(words));
    }
}
