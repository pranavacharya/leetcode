
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int count = 0;
        int local = 1;
        int last = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                local++;
            } else {
                count += Math.min(local, last);
                last = local;
                local = 1;
            }
        }
        return count + Math.min(local, last);
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        System.out.println(cbs.countBinarySubstrings("00110011"));
    }
}
