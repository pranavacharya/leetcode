
public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        TruncateSentence ts = new TruncateSentence();
        System.out.println(ts.truncateSentence("What is the solution to this problem", 4));
    }
}
