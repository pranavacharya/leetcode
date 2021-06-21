
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> first = new ArrayList();
        first.add(1);
        result.add(first);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = result.get(result.size() - 1);
            List<Integer> temp = new ArrayList();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(prev.get(j) + prev.get(j - 1));
                }
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String args[]) {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate(5));
        System.out.println(pt.generate(7));
    }
}
