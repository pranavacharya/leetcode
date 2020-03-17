
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        String s = formText(S);
        String t = formText(T);
        return s.equals(t);
    }

    public String formText(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        System.out.println(bsc.backspaceCompare("ab#c", "ad#c"));
    }
}
