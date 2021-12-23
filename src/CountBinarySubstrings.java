
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int count = 0;
        int local = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                local++;
                i++;
            } else {
                while (i < s.length() && s.charAt(i) == '1') {
                    if (local > 0) {
                        count++;
                    }
                    local--;
                    i++;
                }
                local = 0;
            }

        }
        local = 0;
        i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                local++;
                i++;
            } else {
                while (i < s.length() && s.charAt(i) == '0') {
                    if (local > 0) {
                        count++;
                    }
                    local--;
                    i++;
                }
                local = 0;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        System.out.println(cbs.countBinarySubstrings("10101"));
        System.out.println(cbs.countBinarySubstrings("00110011"));
    }
}
