
public class CheckIfAll1AreatLeastLengthKPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {
        int lastK = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && lastK != -1) {
                int distance = i - lastK - 1;
                if (distance < k) {
                    return false;
                }
                lastK = i;
            } else if (nums[i] == 1) {
                lastK = i;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        CheckIfAll1AreatLeastLengthKPlacesAway cia1alkpw = new CheckIfAll1AreatLeastLengthKPlacesAway();
        int[] nums = new int[]{1, 0, 0, 0, 1, 0, 0, 1};
        System.out.println(cia1alkpw.kLengthApart(nums, 2));
    }
}
