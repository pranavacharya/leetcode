
public class ReplaceAllDigitswithCharacters {

    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                int prev = s.charAt(i - 1) - 'a';
                int digit = Character.getNumericValue(s.charAt(i));
                prev = (digit + prev);
                sb.append((char) ('a' + prev));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceAllDigitswithCharacters radc = new ReplaceAllDigitswithCharacters();
        System.out.println(radc.replaceDigits("a1c1e1"));
    }
}
