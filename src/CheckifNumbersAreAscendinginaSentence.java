
public class CheckifNumbersAreAscendinginaSentence {

    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            try {
                int num = Integer.parseInt(words[i]);
            } catch (Exception e) {
                flag = false;
            }

            if (flag) {
                int num = Integer.parseInt(words[i]);
                if (num <= last) {
                    return false;
                } else {
                    last = num;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckifNumbersAreAscendinginaSentence cinas = new CheckifNumbersAreAscendinginaSentence();
        System.out.println(cinas.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}
