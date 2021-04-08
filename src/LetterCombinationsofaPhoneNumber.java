
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    private HashMap<Character, ArrayList<Character>> map;

    LetterCombinationsofaPhoneNumber() {
        this.map = new HashMap();
        ArrayList<Character> two = new ArrayList();
        two.add('a');
        two.add('b');
        two.add('c');
        ArrayList<Character> three = new ArrayList();
        three.add('d');
        three.add('e');
        three.add('f');
        ArrayList<Character> four = new ArrayList();
        four.add('g');
        four.add('h');
        four.add('i');
        ArrayList<Character> five = new ArrayList();
        five.add('j');
        five.add('k');
        five.add('l');
        ArrayList<Character> six = new ArrayList();
        six.add('m');
        six.add('n');
        six.add('o');
        ArrayList<Character> seven = new ArrayList();
        seven.add('p');
        seven.add('q');
        seven.add('r');
        seven.add('s');
        ArrayList<Character> eight = new ArrayList();
        eight.add('t');
        eight.add('u');
        eight.add('v');
        ArrayList<Character> nine = new ArrayList();
        nine.add('w');
        nine.add('x');
        nine.add('y');
        nine.add('z');
        this.map.put('2', two);
        this.map.put('3', three);
        this.map.put('4', four);
        this.map.put('5', five);
        this.map.put('6', six);
        this.map.put('7', seven);
        this.map.put('8', eight);
        this.map.put('9', nine);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits.length() == 0) {
            return result;
        }
        dfs(digits, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(String s, int index, List<String> result, StringBuilder path) {
        if (index == s.length() && path.length() == s.length()) {
            result.add(path.toString());
            return;
        }
        ArrayList<Character> alpha = this.map.get(s.charAt(index));
        for (int i = 0; i < alpha.size(); i++) {
            char c = alpha.get(i);
            path.append(c);
            dfs(s, index + 1, result, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
        System.out.println(lcpn.letterCombinations("23"));
    }
}
