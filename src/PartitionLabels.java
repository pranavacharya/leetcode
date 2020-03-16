
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length();) {
            int temp = S.lastIndexOf(S.charAt(i));
            for (int j = i + 1; j < temp; j++) {
                if (S.lastIndexOf((S.charAt(j))) > temp) {
                    temp = S.lastIndexOf((S.charAt(j)));
                }
            }
            result.add(temp - i + 1);
            i = temp + 1;
        }
        return result;
    }

    public static void main(String args[]) {
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
