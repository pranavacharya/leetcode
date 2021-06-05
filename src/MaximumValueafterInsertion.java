
public class MaximumValueafterInsertion {

    public String maxValue(String n, int x) {
        boolean isNeg = false;
        if (n.charAt(0) == '-') {
            isNeg = true;
        }
        StringBuilder sb = new StringBuilder();
        if (isNeg) {
            sb.append('-');
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) - '0' <= x) {
                    sb.append(n.charAt(i));
                } else {
                    sb.append("" + x).append(n.substring(i));
                    break;
                }
                if (i == n.length() - 1) {
                    sb.append("" + x);
                }
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) - '0' >= x) {
                    sb.append(n.charAt(i));
                } else {
                    sb.append("" + x).append(n.substring(i));
                    break;
                }
                if (i == n.length() - 1) {
                    sb.append("" + x);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaximumValueafterInsertion mvai = new MaximumValueafterInsertion();
        System.out.println(mvai.maxValue("-132", 3));
    }
}
