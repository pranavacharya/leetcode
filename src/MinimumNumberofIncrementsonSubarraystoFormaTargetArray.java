
public class MinimumNumberofIncrementsonSubarraystoFormaTargetArray {

    public int minNumberOperations(int[] target) {
        int ops = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                ops += target[i] - target[i - 1];
            }
        }
        return ops;
    }

    public static void main(String args[]) {
        MinimumNumberofIncrementsonSubarraystoFormaTargetArray misfta
                = new MinimumNumberofIncrementsonSubarraystoFormaTargetArray();
        int[] arr = new int[]{1, 2, 3, 2, 1};
        System.out.println(misfta.minNumberOperations(arr));
    }
}
