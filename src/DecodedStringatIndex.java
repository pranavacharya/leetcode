
public class DecodedStringatIndex {

    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(S.charAt(i))) {
                size *= Character.getNumericValue(S.charAt(i));
            } else {
                size++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            K %= size;
            char c = S.charAt(i);
            if (K == 0 && Character.isAlphabetic(c)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                size /= Character.getNumericValue(c);
            } else {
                size--;
            }
        }
        return "";
    }

    public static void main(String args[]) {
        DecodedStringatIndex dsi = new DecodedStringatIndex();
        System.out.println(dsi.decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }
}
