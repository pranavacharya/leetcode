
import java.util.Arrays;

public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        String num = Integer.toString(n);
        char[] numarr = num.toCharArray();
        int i = num.length() - 1;
        while (i - 1 >= 0) {
            if (num.charAt(i) == num.charAt(i - 1) || num.charAt(i) < num.charAt(i - 1)) {
                i--;
            } else {
                break;
            }
        }

        if (i == 0) {
            return -1;
        }
        Arrays.sort(numarr, i, numarr.length);
        int swapIndex = i - 1;
        while (i < numarr.length) {
            if (numarr[i] <= numarr[swapIndex]) {
                i++;
            } else {
                break;
            }
        }
        char temp = numarr[i];
        numarr[i] = numarr[swapIndex];
        numarr[swapIndex] = temp;

        String res = new String(numarr);
        long resnum = Long.parseLong(res);
        if (resnum > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) resnum;
    }

    public static void main(String args[]) {
        NextGreaterElementIII ng = new NextGreaterElementIII();
        System.out.println(ng.nextGreaterElement(12));
        System.out.println(ng.nextGreaterElement(1311513132));
        System.out.println(ng.nextGreaterElement(1311513131));
    }
}
