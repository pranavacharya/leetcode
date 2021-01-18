
import java.util.Arrays;

public class DecodeXORedArray {

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }

    public static void main(String args[]) {
        DecodeXORedArray dxa = new DecodeXORedArray();
        int[] encoded = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(dxa.decode(encoded, 1)));
    }
}
