
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public class Compare implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return -1 * compareTO(Integer.toString(o1), Integer.toString(o2));
        }

    }

    private int compareTO(String first, String second) {
        boolean isSwap = false;
        if (second.length() > first.length()) {
            String temp = second;
            second = first;
            first = temp;
            isSwap = true;
        }

        while (second.length() != first.length()) {
            second = second.charAt(0) > second.charAt(second.length() - 1)
                    ? second.concat("" + second.charAt(0)) : second.concat("" + second.charAt(second.length() - 1));
        }
        if (isSwap) {
            return second.compareTo(first);
        }
        return first.compareTo(second);
    }

    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, new Compare());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        LargestNumber ln = new LargestNumber();
//        int[] nums = new int[]{0, 0, 0};
        int[] nums = new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
//        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(ln.largestNumber(nums));
    }
}
