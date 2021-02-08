
import java.util.Arrays;

public class ShortestDistancetoaCharacter {

    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        Arrays.fill(result, Integer.MAX_VALUE);
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < result.length; i++) {
            if (S.charAt(i) == C) {
                distance = 0;
            } else {
                if (distance != Integer.MAX_VALUE) {
                    distance++;
                }
            }
            result[i] = distance;
        }
        distance = Integer.MAX_VALUE;
        for (int i = result.length - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                distance = 0;
            } else {
                if (distance != Integer.MAX_VALUE) {
                    distance++;
                }
            }
            result[i] = Math.min(result[i], distance);
        }
        return result;
    }

    public static void main(String args[]) {
        ShortestDistancetoaCharacter sdtc = new ShortestDistancetoaCharacter();
        System.out.println(Arrays.toString(sdtc.shortestToChar("loveleetcode", 'e')));
    }
}
