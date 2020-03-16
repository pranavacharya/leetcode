
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastOccurrence[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < S.length();) {
            int temp = lastOccurrence[S.charAt(i) - 'a'];
            for (int j = i + 1; j < temp; j++) {
                if (lastOccurrence[S.charAt(j) - 'a'] > temp) {
                    temp = lastOccurrence[S.charAt(j) - 'a'];
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
