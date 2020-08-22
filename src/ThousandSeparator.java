
public class ThousandSeparator {

    public String thousandSeparator(int n) {
        if (n < 1000) {
            return "" + n;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while (n > 0) {
            if (pos != 0 && pos % 3 == 0) {
                sb.append(".");
            }
            sb.append(n % 10);
            n /= 10;
            pos++;
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        ThousandSeparator ts = new ThousandSeparator();
        System.out.println(ts.thousandSeparator(192));
    }
}
