
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (list.contains(arr2[i])) {
                list.remove(new Integer(arr2[i]));
                res[index] = arr2[i];
                index++;
            }
        }
        Collections.sort(list);
        for (int i : list) {
            res[index] = i;
            index++;
        }
        return res;
    }

    public static void main(String args[]) {
        RelativeSortArray rsa = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(rsa.relativeSortArray(arr1, arr2)));
    }
}
