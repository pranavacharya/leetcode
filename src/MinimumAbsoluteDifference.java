
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < arr.length; i++) {
            if (arr[i + 1] - arr[i] > min) {
                continue;
            } else if (arr[i + 1] - arr[i] < min) {
                result.clear();
            }
            List<Integer> temp = new ArrayList();
            temp.add(arr[i]);
            temp.add(arr[i + 1]);
            result.add(temp);
            min = arr[i + 1] - arr[i];
        }
        return result;
    }

    public static void main(String args[]) {
        MinimumAbsoluteDifference mad = new MinimumAbsoluteDifference();
        int[] arr = new int[]{4, 2, 1, 3};
        System.out.println(mad.minimumAbsDifference(arr));
    }
}
