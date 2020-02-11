
import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    private List<List<Integer>> output;

    public ThreeSum() {
        this.output = new ArrayList<>();
    }

    public void subset(ArrayList<Integer> soFar, ArrayList<Integer> rem) {
        if (soFar.size() == 3) {
            int sum = 0;
            for (Integer i : soFar) {
                sum += (int) i;
            }
            if (sum == 0) {
                output.add(soFar);
            }
        } else if (!rem.isEmpty()) {
            ArrayList<Integer> leftwith;
            ArrayList<Integer> leftwithout;
            ArrayList<Integer> right;
            leftwith = (ArrayList<Integer>) soFar.clone();
            leftwith.add(rem.get(0));
            leftwithout = (ArrayList<Integer>) soFar.clone();
            right = (ArrayList<Integer>) rem.clone();
            right.remove(0);
            subset(leftwith, right);
            subset(leftwithout, right);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ThreeSum ts = new ThreeSum();
        ArrayList inputlist = new ArrayList<>();
        for (int in : nums) {
            inputlist.add(in);
        }
        ts.subset(new ArrayList<>(), inputlist);
        return ts.output;
    }

    public static void main(String args[]) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(input));
    }
}
