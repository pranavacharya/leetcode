
import java.util.Arrays;

public class DivideaStringIntoGroupsofSizek {

    public String[] divideString(String s, int k, char fill) {
        int len = s.length() / k;
        if (s.length() % k != 0) {
            len++;
        }
        String[] str = new String[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            String temp = s.substring(index, Math.min(s.length(), index + k));
            while (temp.length() < k) {
                temp = temp.concat("" + fill);
            }
            str[i] = temp;

            index += k;
        }
        return str;
    }

    public static void main(String[] args) {
        DivideaStringIntoGroupsofSizek dsigk = new DivideaStringIntoGroupsofSizek();
        System.out.println(Arrays.toString(dsigk.divideString("ctoyjrwtngqwt", 8, 'n')));
    }
}
