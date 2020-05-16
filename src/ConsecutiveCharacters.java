
public class ConsecutiveCharacters {

    public int maxPower(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            j = i;
            while (j < arr.length && arr[i] == arr[j]) {
                j++;
            }
            count = Math.max(count, j - i);
            i++;
        }
        return count;
    }

    public static void main(String args[]) {
        ConsecutiveCharacters cc = new ConsecutiveCharacters();
        System.out.println(cc.maxPower("leetcode"));
    }
}
