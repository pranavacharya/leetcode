
public class SplitAStringInBalancedString {

    public int balancedStringSplit(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R') {
                sum = sum + 1;
            }
            if (arr[i] == 'L') {
                sum = sum - 1;
            }
            if (sum == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        SplitAStringInBalancedString sasibs = new SplitAStringInBalancedString();
        System.out.println(sasibs.balancedStringSplit("RLRRRLLRLL"));
    }

}
