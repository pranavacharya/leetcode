
import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                min++;
            } else {
                j--;
                min++;
            }
        }
        return min;
    }

    public static void main(String args[]) {
        BoatsToSavePeople btsp = new BoatsToSavePeople();
        int[] people = new int[]{3, 2, 2, 1};
        System.out.println(btsp.numRescueBoats(people, 3));
    }
}
