
import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList();
        for (int i = 2; i < s.length() - 1; i++) {
            List<String> first = generateCombination(s.substring(1, i));
            List<String> second = generateCombination(s.substring(i, s.length() - 1));
            for (int j = 0; j < first.size(); j++) {
                for (int k = 0; k < second.size(); k++) {
                    String combo = "(" + first.get(j) + ", " + second.get(k) + ")";
                    result.add(combo);
                }
            }
        }
        return result;
    }

    private List<String> generateCombination(String s) {
        List<String> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            String prev = s.substring(0, i + 1);
            int prevZero = 0;
            for (int j = 0; j < prev.length(); j++) {
                if (prev.charAt(j) == '0') {
                    prevZero++;
                } else {
                    break;
                }
            }
            int endZero = 0;
            String end = s.substring(i + 1);
            for (int j = end.length() - 1; j >= 0; j--) {
                if (end.charAt(j) == '0') {
                    endZero++;
                } else {
                    break;
                }
            }
            if ((prevZero < 1 || prev.length() == 1) && (endZero < 1 || end.isBlank())) {
                if (end.isBlank()) {
                    list.add(prev);
                } else {
                    String combination = prev + "." + end;
                    list.add(combination);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates ac = new AmbiguousCoordinates();
        System.out.println(ac.ambiguousCoordinates("(0123)"));
        System.out.println(ac.ambiguousCoordinates("(0010)"));
        System.out.println(ac.ambiguousCoordinates("(123)"));
        System.out.println(ac.ambiguousCoordinates("(00011)"));
    }
}
