
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp) && !result.contains(temp)) {
                result.add(temp);
            } else {
                set.add(temp);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        RepeatedDNASequence pds = new RepeatedDNASequence();
        System.out.println(pds.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(pds.findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }
}
