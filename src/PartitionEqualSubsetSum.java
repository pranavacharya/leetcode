
import java.util.ArrayList;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        ArrayList numlist = new ArrayList<>();
        for (int i : nums) {
            numlist.add(i);
        }
        return subset(new ArrayList(), numlist);
    }

    public boolean subset(ArrayList<Integer> soFar, ArrayList<Integer> rem) {
        if (isSumEqual(soFar, rem)) {
            return true;
        } else if (rem.isEmpty()) {
            return false;
        } else {
            int size = rem.size();
            for (int i = 0; i < size; i++) {
                ArrayList left = new ArrayList(soFar);
                left.add(rem.get(i));
                ArrayList right = new ArrayList(rem);
                right.remove(i);
                if (subset(left, right)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isSumEqual(ArrayList<Integer> left, ArrayList<Integer> right) {
        int sum1 = 0, sum2 = 0;
        for (int i : left) {
            sum1 += i;
        }
        for (int i : right) {
            sum2 += i;
        }
        return sum1 == sum2;
    }

    public static void main(String args[]) {
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(pess.canPartition(nums));
    }
}
