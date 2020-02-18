
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2){
        Map<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        for(int num: arr2) map.put(num,0);
        for(int i = 0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],map.get(arr1[i])+1);
                arr1[i] = -1;
            }
        }
        Arrays.sort(arr1);
        for(int num: arr2){
            int size = map.remove(num);
            while (size > 0){
                arr1[counter++] = num;
                size--;
            }
        }
        return arr1;
    }

    public static void main(String args[]) {
        RelativeSortArray rsa = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(rsa.relativeSortArray(arr1, arr2)));
    }
}
