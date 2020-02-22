
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortIntegerByBits {

    public int[] sortByBits(int[] arr) {
        int[] res = new int[arr.length];
        int c = 0;
        ArrayList<Integer>[] data = new ArrayList[20];
        for (int i = 0; i < data.length; i++) {
            data[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < arr.length; i++) {
            data[convertToBinaryAndCountBits(arr[i])].add(arr[i]);
        }
        for (ArrayList l : data) {
            if (l != null && !l.isEmpty()) {
                Collections.sort(l);
                for (Object i : l) {
                    res[c] = (int) i;
                    c++;
                }
            }
        }
        return res;
    }

    public int convertToBinaryAndCountBits(int num) {
        int count = 0;
        String binary = Integer.toBinaryString(num);
        for (char i : binary.toCharArray()) {
            if (i == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        SortIntegerByBits siby = new SortIntegerByBits();
        int[] arr = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println(Arrays.toString(siby.sortByBits(arr)));
    }
}
