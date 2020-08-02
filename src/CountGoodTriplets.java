
public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[j] - arr[k]) > b || Math.abs(arr[i] - arr[k]) > c) {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CountGoodTriplets cgt = new CountGoodTriplets();
        int[] arr = new int[]{3, 0, 1, 1, 9, 7};
        System.out.println(cgt.countGoodTriplets(arr, 7, 2, 3));
    }
}
