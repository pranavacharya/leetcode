
import java.util.HashMap;

public class SatisfiabilityofEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        HashMap<Character, Character> map = new HashMap();
        for (String equation : equations) {
            char var1 = equation.charAt(0);
            char var2 = equation.charAt(3);
            char ops = equation.charAt(1);
            if (ops == '=') {
                union(var1, var2, map);
            }
        }
        for (String equation : equations) {
            char var1 = equation.charAt(0);
            char var2 = equation.charAt(3);
            char ops = equation.charAt(1);
            if (ops == '!') {
                if (find(var1, map) == find(var2, map)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(Character c, Character d, HashMap<Character, Character> map) {
        char cp = find(c, map);
        char dp = find(d, map);
        if (cp != dp) {
            map.put(dp, cp);
        }
    }

    private Character find(Character c, HashMap<Character, Character> map) {
        if (map.containsKey(c)) {
            while (map.get(c) != c) {
                c = map.get(c);
            }
            return c;
        } else {
            map.put(c, c);
            return c;
        }
    }

    public static void main(String args[]) {
        SatisfiabilityofEqualityEquations see = new SatisfiabilityofEqualityEquations();
        String[] equations = new String[]{"c==c", "b==d", "x!=z"};
        System.out.println(see.equationsPossible(equations));
    }
}
