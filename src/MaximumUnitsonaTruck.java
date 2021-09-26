
import java.util.Arrays;

public class MaximumUnitsonaTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, ((a, b) -> b[1] - a[1]));
        int units = 0;
        int index = 0;
        while (truckSize > 0 && index < boxTypes.length) {
            if (truckSize > boxTypes[index][0]) {
                truckSize -= boxTypes[index][0];
                units += (boxTypes[index][0] * boxTypes[index][1]);
            } else {
                units += truckSize * boxTypes[index][1];
                truckSize = 0;
            }
            index++;
        }
        return units;
    }

    public static void main(String args[]) {
        MaximumUnitsonaTruck mut = new MaximumUnitsonaTruck();
        int[][] boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(mut.maximumUnits(boxTypes, 10));
    }
}
