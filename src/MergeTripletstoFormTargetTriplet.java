
import java.util.ArrayList;

public class MergeTripletstoFormTargetTriplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false;
        boolean second = false;
        boolean third = false;
        ArrayList<Integer> lista = new ArrayList();
        for (int i = 0; i < triplets.length; i++) {
            int a = triplets[i][0];
            if (a <= target[0]) {
                lista.add(i);
            }
        }
        ArrayList<Integer> listb = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            int index = lista.get(i);
            int b = triplets[index][1];
            if (b <= target[1]) {
                listb.add(index);
            }
        }
        ArrayList<Integer> listc = new ArrayList();
        for (int i = 0; i < listb.size(); i++) {
            int index = listb.get(i);
            int c = triplets[index][2];
            if (c <= target[2]) {
                listc.add(index);
            }
        }
        for (int i = 0; i < listc.size(); i++) {
            int index = listc.get(i);
            if (triplets[index][0] == target[0]) {
                first = true;
            }
            if (triplets[index][1] == target[1]) {
                second = true;
            }
            if (triplets[index][2] == target[2]) {
                third = true;
            }
        }
        return first && second && third;
    }

    public static void main(String[] args) {
        MergeTripletstoFormTargetTriplet mtftt = new MergeTripletstoFormTargetTriplet();
        int[][] triplets = new int[][]{{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target = new int[]{2, 7, 5};
        System.out.println(mtftt.mergeTriplets(triplets, target));
    }
}
