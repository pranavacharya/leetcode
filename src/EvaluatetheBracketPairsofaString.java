
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class EvaluatetheBracketPairsofaString {

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> temp = knowledge.get(i);
            map.put(temp.get(0), temp.get(1));
        }
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '(') {
                        String key = temp.reverse().toString();
                        if (map.containsKey(key)) {
                            String t = map.get(key);
                            for (int j = 0; j < t.length(); j++) {
                                stack.push(t.charAt(j));
                            }
                        } else {
                            stack.push('?');
                        }
                        break;
                    } else {
                        temp.append(c);
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        EvaluatetheBracketPairsofaString ebps = new EvaluatetheBracketPairsofaString();
        List<List<String>> knowledge = new ArrayList();
        List<String> one = new ArrayList();
        one.add("name");
        one.add("bob");
        List<String> two = new ArrayList();
        two.add("age");
        two.add("two");
        knowledge.add(one);
        knowledge.add(two);
        System.out.println(ebps.evaluate("(name)is(age)yearsold", knowledge));
    }
}
