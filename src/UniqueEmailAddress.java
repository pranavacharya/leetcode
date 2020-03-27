
import java.util.HashSet;

public class UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String e : emails) {
            e = rule1(e);
            e = rule2(e);
            set.add(e);
        }
        return set.size();
    }

    public String rule1(String s) {
        int at = s.indexOf("@");
        String b = s.substring(0, at).replace(".", "").concat(s.substring(at, s.length()));
        return b;
    }

    public String rule2(String s) {
        int at = s.lastIndexOf("@");
        int plus = s.indexOf("+");
        if (plus != -1) {
            String b = s.substring(0, plus).concat(s.substring(at, s.length()));
            return b;
        }
        return s;
    }

    public static void main(String args[]) {
        UniqueEmailAddress uea = new UniqueEmailAddress();
        String[] input = new String[]{"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(uea.numUniqueEmails(input));
    }
}
