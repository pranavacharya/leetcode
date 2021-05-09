
public class MaximumPopulationYear {

    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[2051];
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                arr[i]++;
            }
        }
        int max = 0;
        int year = 0;
        for (int i = 1950; i < 2051; i++) {
            if (max < arr[i]) {
                max = arr[i];
                year = i;
            }
        }
        return year;
    }

    public static void main(String[] args) {
        MaximumPopulationYear mpy = new MaximumPopulationYear();
        int[][] logs = new int[][]{{1993, 1999}, {2000, 2010}};
        System.out.println(mpy.maximumPopulation(logs));
    }
}
