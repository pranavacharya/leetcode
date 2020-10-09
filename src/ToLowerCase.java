
public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ((int) c >= 65 && (int) c <= 90) {
                sb.append((char) ((int) c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        ToLowerCase tlc = new ToLowerCase();
        System.out.println(tlc.toLowerCase("Hello"));
    }
}
