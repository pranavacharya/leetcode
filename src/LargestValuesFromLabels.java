
import java.util.HashMap;
import java.util.PriorityQueue;

public class LargestValuesFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (values[b] - values[a]));
        for (int i = 0; i < labels.length; i++) {
            maxHeap.add(i);
        }

        HashMap<Integer, Integer> result = new HashMap<>();
        int maxSum = 0;

        while (!maxHeap.isEmpty() && num_wanted > 0) {
            int largest = maxHeap.remove();

            if (result.containsKey(labels[largest])) {
                if (result.get(labels[largest]) < use_limit) {
                    maxSum += values[largest];
                    num_wanted--;
                    result.put(labels[largest], result.getOrDefault(labels[largest], 0) + 1);
                }
            } else {
                maxSum += values[largest];
                num_wanted--;
                result.put(labels[largest], 1);
            }
        }

        return maxSum;
    }

    public static void main(String args[]) {
        LargestValuesFromLabels lvfl = new LargestValuesFromLabels();
        int[] values = new int[]{9, 8, 8, 7, 6};
        int[] labels = new int[]{0, 0, 0, 1, 1};
        System.out.println(lvfl.largestValsFromLabels(values, labels, 3, 2));
    }
}
