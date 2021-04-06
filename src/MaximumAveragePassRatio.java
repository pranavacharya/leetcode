
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)
                -> Double.compare(
                        ((double) classes[b][0] + 1) / (double) (classes[b][1] + 1)
                        - ((double) classes[b][0] / (double) classes[b][1]),
                        ((double) classes[a][0] + 1) / (double) (classes[a][1] + 1)
                        - ((double) classes[a][0] / (double) classes[a][1])));

        for (int i = 0; i < classes.length; i++) {
            maxHeap.add(i);
        }

        while (extraStudents > 0) {
            int index = maxHeap.poll();
            classes[index][0]++;
            classes[index][1]++;
            maxHeap.add(index);
            extraStudents--;
        }

        double total = 0.0;
        for (int i = 0; i < classes.length; i++) {
            total += ((double) classes[i][0] / (double) classes[i][1]);
        }

        return (double) total / (double) classes.length;
    }

    public static void main(String[] args) {
        MaximumAveragePassRatio mapr = new MaximumAveragePassRatio();
        int[][] classes = new int[][]{{1, 2}, {3, 5}, {2, 2}};
        System.out.println(mapr.maxAverageRatio(classes, 2));
    }
}
