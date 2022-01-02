
public class CheckifAllAAppearsBeforeAllB {

    public boolean checkString(String s) {
        boolean seen = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                seen = true;
            }

            if (seen && s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckifAllAAppearsBeforeAllB cabb = new CheckifAllAAppearsBeforeAllB();
        System.out.println(cabb.checkString("abab"));
    }
}
