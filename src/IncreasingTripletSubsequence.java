
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(its.increasingTriplet(nums));
    }
}
