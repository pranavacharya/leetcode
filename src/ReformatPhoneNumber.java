
public class ReformatPhoneNumber {

    public String reformatNumber(String number) {
        number = number.replace("-", "");
        number = number.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        int end = number.length();
        if (number.length() % 3 == 1) {
            end = number.length() - 4;
        }
        int i = 0;
        for (i = 0; i < end; i++) {
            if (i != 0 && i % 3 == 0) {
                sb.append("-");
            }
            sb.append(number.charAt(i));
        }

        for (int j = i, k = 0; j < number.length(); j++, k++) {
            if (j != 0 && k % 2 == 0) {
                sb.append("-");
            }
            sb.append(number.charAt(j));
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        System.out.println(rpn.reformatNumber("1-23-45 6"));
        System.out.println(rpn.reformatNumber("123 4-567"));
        System.out.println(rpn.reformatNumber("123 4-5678"));
        System.out.println(rpn.reformatNumber("--17-5 229 35-39475 "));
        System.out.println(rpn.reformatNumber("9964-"));
    }
}
