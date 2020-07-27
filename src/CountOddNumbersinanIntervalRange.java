
public class CountOddNumbersinanIntervalRange {

    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else if ((low % 2 == 0 && high % 2 != 0) || (low % 2 != 0 && high % 2 == 0)) {
            return (high - low) / 2 + 1;
        } else {
            return (high - low) / 2 + 1;
        }
    }

    public static void main(String args[]) {
        CountOddNumbersinanIntervalRange conir = new CountOddNumbersinanIntervalRange();
        System.out.println(conir.countOdds(8, 11));
    }
}
