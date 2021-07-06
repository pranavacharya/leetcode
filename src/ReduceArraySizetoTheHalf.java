
import java.util.Arrays;
import java.util.HashMap;

public class ReduceArraySizetoTheHalf {

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        int[] freqs = new int[freq.size()];
        int index = 0;
        for (int key : freq.keySet()) {
            freqs[index++] = freq.get(key);
        }
        Arrays.sort(freqs);
        int size = arr.length / 2;
        int sum = 0;
        for (int i = freqs.length - 1; i >= 0; i--) {
            sum += freqs[i];
            if (sum >= size) {
                return freqs.length - i;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        ReduceArraySizetoTheHalf rash = new ReduceArraySizetoTheHalf();
        int[] arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(rash.minSetSize(arr));
    }
}
