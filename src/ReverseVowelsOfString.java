
import java.util.HashSet;

public class ReverseVowelsOfString {

    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] characters = s.toCharArray();
        int i = 0;
        int j = characters.length - 1;
        while (i < j) {
            while (i < j && !set.contains(characters[i])) {
                i++;
            }
            while (i < j && !set.contains(characters[j])) {
                j--;
            }
            char temp = characters[i];
            characters[i++] = characters[j];
            characters[j--] = temp;
        }
        return new String(characters);
    }

    public static void main(String args[]) {
        ReverseVowelsOfString rvos = new ReverseVowelsOfString();
        System.out.println(rvos.reverseVowels("leetcode"));
    }
}
