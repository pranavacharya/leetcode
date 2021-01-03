
import java.util.PriorityQueue;

public class MaximumUnitsonaTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)
                -> (boxTypes[b][1] - boxTypes[a][1]));
        for (int i = 0; i < boxTypes.length; i++) {
            maxHeap.add(i);
        }
        int units = 0;
        while (truckSize > 0 && !maxHeap.isEmpty()) {
            int index = maxHeap.poll();
            int boxes = boxTypes[index][0];
            int unitsPerBox = boxTypes[index][1];
            if (boxes <= truckSize) {
                truckSize -= boxes;
                units += boxes * unitsPerBox;
            } else {
                int diff = truckSize;
                truckSize = 0;
                units += diff * unitsPerBox;
            }
        }
        return units;
    }

    public static void main(String args[]) {
        MaximumUnitsonaTruck mut = new MaximumUnitsonaTruck();
        int[][] boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(mut.maximumUnits(boxTypes, 10));
    }
}
