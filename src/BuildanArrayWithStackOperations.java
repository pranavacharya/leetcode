
import java.util.ArrayList;
import java.util.List;

public class BuildanArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList();
        for (int i = 0, j = 1; i < target.length; j++) {
            if (target[i] == j) {
                result.add("Push");
                i++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }

    public static void main(String args[]) {
        BuildanArrayWithStackOperations bawso = new BuildanArrayWithStackOperations();
        int[] target = new int[]{1, 3};
        System.out.println(bawso.buildArray(target, 3));
    }
}
