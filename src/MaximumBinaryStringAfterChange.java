
public class MaximumBinaryStringAfterChange {

    public String maximumBinaryString(String binary) {
        int zeros = 0;
        int beginOnes = 0;
        int index = 0;
        while (index < binary.length()) {
            if (binary.charAt(index) == '1') {
                beginOnes++;
                index++;
            } else {
                break;
            }
        }
        for (int i = index; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                zeros++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= beginOnes; i++) {
            sb.append('1');
        }
        for (int i = 1; i < zeros; i++) {
            sb.append('1');
        }
        if (zeros > 0) {
            sb.append('0');
        }
        for (int i = 1; i <= binary.length() - zeros - beginOnes; i++) {
            sb.append('1');
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        MaximumBinaryStringAfterChange mbsc = new MaximumBinaryStringAfterChange();
        System.out.println(mbsc.maximumBinaryString("101010111011001101000110010001100001111"));
    }
}
