
public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        int time = 0;
        double wt = 0;
        for (int i = 0; i < customers.length; i++) {
            int initTime = customers[i][0];
            int prepTime = customers[i][1];

            int timeTaken = 0;
            if (initTime < time) {
                timeTaken += time - initTime;
            } else {
                time = initTime;
            }
            timeTaken += prepTime;
            time += prepTime;
            wt += timeTaken;;
        }
        return wt / customers.length;
    }

    public static void main(String args[]) {
        AverageWaitingTime awt = new AverageWaitingTime();
        int[][] customers = new int[][]{{1, 2}, {2, 5}, {4, 3}};
        System.out.println(awt.averageWaitingTime(customers));
    }
}
