
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverse2 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        int n = 0;
        for (List l : nums) {
            n = Math.max(n, l.size());
        }
        ArrayList<Integer>[] diagonal = new ArrayList[m + n - 1];
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int value = nums.get(i).get(j);
                if (diagonal[i + j] == null) {
                    diagonal[i + j] = new ArrayList();
                }
                diagonal[i + j].add(value);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < diagonal.length; i++) {
            if (diagonal[i] != null) {
                for (int j = 0; j < diagonal[i].size(); j++) {
                    temp.add(diagonal[i].get(j));
                }
            }
        }
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }

    public static void main(String args[]) {
        DiagonalTraverse2 dt2 = new DiagonalTraverse2();
        ArrayList<Integer> row1 = new ArrayList<>();
        ArrayList<Integer> row2 = new ArrayList<>();
        ArrayList<Integer> row3 = new ArrayList<>();
        ArrayList<Integer> row4 = new ArrayList<>();
        row1.add(5);
        row1.add(6);
        row1.add(3);
        row1.add(10);
        row2.add(9);
        row3.add(1);
        row3.add(19);
        row4.add(9);
        row4.add(9);
        row4.add(2);
        List<List<Integer>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        list.add(row3);
        list.add(row4);
        System.out.println(Arrays.toString(dt2.findDiagonalOrder(list)));
    }
}
