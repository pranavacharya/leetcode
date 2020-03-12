
import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int min = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            min++;
        }
        return min;
    }

    public static void main(String args[]) {
        BoatsToSavePeople btsp = new BoatsToSavePeople();
        int[] people = new int[]{3, 2, 2, 1};
        System.out.println(btsp.numRescueBoats(people, 3));
    }
}
