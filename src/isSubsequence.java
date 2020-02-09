
public class isSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = 0;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        while (j < tArray.length) {
            if (sArray[i] == tArray[j]) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i >= sArray.length) {
                break;
            }
        }
        return (i >= sArray.length);
    }

    public static void main(String args[]) {
        isSubsequence is = new isSubsequence();
        System.out.println(is.isSubsequence("abc","agsbsgacvaf"));
    }
}
