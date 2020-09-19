
public class SumofAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int[] prefixSum = new int[arr.length + 1];
        int sumcarry = 0;
        for (int i = 0; i < arr.length; i++) {
            sumcarry += arr[i];
            prefixSum[i + 1] = sumcarry;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((j - i) % 2 == 0) {
                    sum += (prefixSum[j + 1] - prefixSum[i]);
                }
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        SumofAllOddLengthSubarrays saols = new SumofAllOddLengthSubarrays();
        int[] arr = new int[]{1, 4, 2, 5, 3};
        System.out.println(saols.sumOddLengthSubarrays(arr));
    }
}
