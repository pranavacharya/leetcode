
public class StringCompression {

    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        int w = 0;
        while (j < chars.length) {
            if (chars[i] != chars[j]) {
                chars[w] = chars[i];
                w++;
                if (j - i > 1) {
                    String valstring = Integer.toString(j - i);
                    for (char v : valstring.toCharArray()) {
                        chars[w] = v;
                        w++;
                    }
                }
                i = j;
            } else {
                j++;
            }
        }
        if (i != j) {
            chars[w] = chars[i];
            w++;
            if (j - i > 1) {
                String valstring = Integer.toString(j - i);
                for (char v : valstring.toCharArray()) {
                    chars[w] = v;
                    w++;
                }
            }
        }
        System.out.println(chars);
        return w;
    }

    public static void main(String args[]) {
        StringCompression sc = new StringCompression();
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(sc.compress(chars));
    }
}
