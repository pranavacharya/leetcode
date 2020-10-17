
import java.util.Arrays;

public class MeanofArrayAfterRemovingSomeElements {

    public double trimMean(int[] arr) {
        int length = arr.length;
        int element = length / 20;
        Arrays.sort(arr);
        double sum = 0;
        double count = 0;
        for (int i = 0 + element; i < length - element; i++) {
            sum += arr[i];
            count++;
        }
        return sum / count;
    }

    public static void main(String args[]) {
        MeanofArrayAfterRemovingSomeElements maare = new MeanofArrayAfterRemovingSomeElements();
        int[] arr = new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        System.out.println(maare.trimMean(arr));
    }
}
