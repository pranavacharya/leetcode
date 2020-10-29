
public class MaximizeDistancetoClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (count % 2 == 0) {
                    int local = count / 2;
                    max = Math.max(max, local);

                } else {
                    int local = (count - 1) / 2 + 1;
                    max = Math.max(max, local);
                }
                count = 0;
            } else {
                count++;
            }
        }

        int index = 0;
        while (seats[index] == 0) {
            index++;
        }
        max = Math.max(max, index);

        index = seats.length - 1;
        while (seats[index] == 0) {
            index--;
        }
        max = Math.max(max, seats.length - 1 - index);

        return max;
    }

    public static void main(String args[]) {
        MaximizeDistancetoClosestPerson mdcp = new MaximizeDistancetoClosestPerson();
        int[] seats = new int[]{1, 0, 0, 0, 1, 0, 1};
        System.out.println(mdcp.maxDistToClosest(seats));
    }
}
