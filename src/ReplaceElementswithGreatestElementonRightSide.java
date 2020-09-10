
import java.util.Arrays;

public class ReplaceElementswithGreatestElementonRightSide {

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                max = Math.max(max, arr[i]);
                arr[i] = -1;
            } else {
                int temp = arr[i];
                arr[i] = max;
                max = Math.max(max, temp);
            }
        }
        return arr;
    }

    public static void main(String args[]) {
        ReplaceElementswithGreatestElementonRightSide rewgers = new ReplaceElementswithGreatestElementonRightSide();
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(rewgers.replaceElements(arr)));
    }
}
