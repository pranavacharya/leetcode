
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                balance++;
            } else if (--balance == -1) {
                return false;
            }
        }
        balance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                balance++;
            } else if (--balance == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ValidParenthesisString vps = new ValidParenthesisString();
        System.out.println(vps.checkValidString("(*))"));
    }
}
