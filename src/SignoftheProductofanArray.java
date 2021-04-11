
public class SignoftheProductofanArray {

    public int arraySign(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                count++;
            }
        }
        return count % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        SignoftheProductofanArray sopa = new SignoftheProductofanArray();
        int[] arr = new int[]{-1, -2, -3, -4, 3, 2, 1};
        System.out.println(sopa.arraySign(arr));
    }
}
