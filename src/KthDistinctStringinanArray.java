
import java.util.HashMap;

public class KthDistinctStringinanArray {

    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                k--;
            }
            if (k == 0) {
                return arr[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        KthDistinctStringinanArray kdsa = new KthDistinctStringinanArray();
        String[] arr = new String[]{"d", "b", "c", "b", "c", "a"};
        System.out.println(kdsa.kthDistinct(arr, 2));
    }
}
