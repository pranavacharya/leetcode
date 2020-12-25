
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class UncommonWordsfromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {
        HashSet<String> setA = new HashSet();
        HashSet<String> setB = new HashSet();
        HashSet<String> dup = new HashSet();
        String[] wordsA = A.split(" ");
        for (String word : wordsA) {
            if (!setA.contains(word)) {
                setA.add(word);
            } else {
                dup.add(word);
            }
        }
        String[] wordsB = B.split(" ");
        for (String word : wordsB) {
            if (!setB.contains(word)) {
                setB.add(word);
            } else {
                dup.add(word);
            }
        }
        HashSet<String> temp = new HashSet(setA);
        setA.removeAll(setB);
        setB.removeAll(temp);
        setA.removeAll(dup);
        setB.removeAll(dup);
        ArrayList<String> list = new ArrayList(setA);
        list.addAll(setB);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String args[]) {
        UncommonWordsfromTwoSentences uwts = new UncommonWordsfromTwoSentences();
        System.out.println(Arrays.toString(uwts.uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }
}
