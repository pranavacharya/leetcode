
import java.util.HashSet;

public class CheckIfDoubleExist {

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int countzero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countzero++;
                if (countzero > 2) {
                    return true;
                }
            }
            if (set.contains(arr[i])) {
                return true;
            } else {
                set.add(arr[i] * 2);
                if (arr[i] % 2 == 0) {
                    set.add(arr[i] / 2);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        CheckIfDoubleExist cide = new CheckIfDoubleExist();
        int[] arr = new int[]{3, 1, 7, 11};
        System.out.println(cide.checkIfExist(arr));
    }
}
