
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() != 0) {
                return words[i].length();
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        LengthofLastWord llw = new LengthofLastWord();
        System.out.println(llw.lengthOfLastWord("Hello World"));
    }
}
