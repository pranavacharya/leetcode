
public class PairsofSongsWithTotalDurationsDivisibleby60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i] % 60 == 0) {
                count += remainder[0];
            } else {
                count += remainder[60 - time[i] % 60];
            }
            remainder[time[i] % 60]++;
        }
        return count;
    }

    public static void main(String args[]) {
        PairsofSongsWithTotalDurationsDivisibleby60 pswtddb = new PairsofSongsWithTotalDurationsDivisibleby60();
        int[] arr = new int[]{30, 20, 150, 100, 40};
        System.out.println(pswtddb.numPairsDivisibleBy60(arr));
    }
}
