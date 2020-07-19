
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            if (b.charAt(j) - '0' + a.charAt(i) - '0' + carry == 3) {
                sum.append("1");
            } else if (b.charAt(j) - '0' + a.charAt(i) - '0' + carry == 2) {
                sum.append("0");
                if (carry == 0) {
                    carry++;
                }
            } else {
                sum.append("" + (b.charAt(j) - '0' + a.charAt(i) - '0' + carry));
                carry = 0;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (a.charAt(i) - '0' + carry == 2) {
                sum.append("0");
            } else {
                sum.append("" + (a.charAt(i) - '0' + carry));
                carry = 0;
            }
            i--;
        }
        while (j >= 0) {
            if (b.charAt(j) - '0' + carry == 2) {
                sum.append("0");
            } else {
                sum.append("" + (b.charAt(j) - '0' + carry));
                carry = 0;
            }
            j--;
        }
        if (carry != 0) {
            sum.append("1");
        }
        return sum.reverse().toString();
    }

    public static void main(String args[]) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("1010", "1011"));
        System.out.println(ab.addBinary("11", "1"));
        System.out.println(ab.addBinary("1", "11"));
        System.out.println(ab.addBinary("1", "111"));
        System.out.println(ab.addBinary("110010", "10111"));

    }
}
