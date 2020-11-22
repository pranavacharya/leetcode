
public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 'a';
            k--;
        }
        int z = k / 25;
        int rem = k % 25;
        int index = arr.length - 1;
        for (index = arr.length - 1; index >= 0 && z > 0; index--, z--) {
            arr[index] = 'z';
        }
        for (int i = 0; i < rem; i++) {
            arr[index]++;
        }
        return String.valueOf(arr);
    }

    public static void main(String args[]) {
        SmallestStringWithAGivenNumericValue sswgnv = new SmallestStringWithAGivenNumericValue();
        System.out.println(sswgnv.getSmallestString(3, 27));
    }
}
