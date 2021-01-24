
public class LatestTimebyReplacingHiddenDigits {

    public String maximumTime(String time) {
        char[] t = time.toCharArray();
        for (int i = 0; i < t.length; i++) {
            if (t[i] == '?') {
                if (i == 0) {
                    if (t[i + 1] == '?' || (t[i + 1] >= '0' && t[i + 1] <= '3')) {
                        t[i] = '2';
                    } else {
                        t[i] = '1';
                    }
                } else if (i == 1) {
                    if (t[i - 1] == '2') {
                        t[i] = '3';
                    } else {
                        t[i] = '9';
                    }
                } else if (i == 3) {
                    if (t[i + 1] == '?' || t[i + 1] == '0') {
                        t[i] = '5';
                    } else {
                        t[i] = '5';
                    }
                } else if (i == 4) {
                    if (t[i - 1] == '6') {
                        t[i] = '0';
                    } else {
                        t[i] = '9';
                    }
                }
            }
        }
        return new String(t);
    }

    public static void main(String args[]) {
        LatestTimebyReplacingHiddenDigits ltrhd = new LatestTimebyReplacingHiddenDigits();
        System.out.println(ltrhd.maximumTime("2?:?0"));
    }
}
