import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombination {

    public ArrayList<String> output = new ArrayList<>();
    HashMap<String, String> numbers;

    public LetterCombination() {
        this.numbers = new HashMap<>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
    }

    public void letterCombinations(String combination, String digits) {
        if (digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = digits.substring(0, 1);
            String letters = numbers.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                letterCombinations(combination + letter, digits.substring(1));
            }
        }
    }

    public static void main(String args[]) {
        LetterCombination lc = new LetterCombination();
        lc.letterCombinations("", "23");
        System.out.println(lc.output);
    }
}

