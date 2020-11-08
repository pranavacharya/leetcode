
public class GetMaximuminGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 1; 2 * i + 1 < arr.length; i++) {
            arr[i * 2] = arr[i];
            arr[i * 2 + 1] = arr[i] + arr[i + 1];
            max = Math.max(max, arr[i * 2]);
            max = Math.max(max, arr[i * 2 + 1]);
        }
        return max;
    }

    public static void main(String args[]) {
        GetMaximuminGeneratedArray gmga = new GetMaximuminGeneratedArray();
        System.out.println(gmga.getMaximumGenerated(3));
    }
}
