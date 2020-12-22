
public class DecodedStringatIndex {

    public String decodeAtIndex(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isAlphabetic(S.charAt(i))) {
                sb.append(S.charAt(i));
                if (K == sb.length()) {
                    return "" + sb.charAt(sb.length() - 1);
                }
            } else {
                int len = sb.length();
                int times = Character.getNumericValue(S.charAt(i));
                if (len * times < K) {
                    String temp = sb.toString();
                    for (int j = 0; j < times - 1; j++) {
                        sb.append(temp);
                    }
                } else {
                    int index = (K - 1) % len;
                    return "" + sb.charAt(index);
                }
            }
        }
        return "";
    }

    public static void main(String args[]) {
        DecodedStringatIndex dsi = new DecodedStringatIndex();
        System.out.println(dsi.decodeAtIndex("leet2code3", 10));
    }
}
