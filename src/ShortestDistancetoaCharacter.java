
import java.util.Arrays;

public class ShortestDistancetoaCharacter {

    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = shortestDistance(i, S, C);
        }
        return result;
    }

    public int shortestDistance(int index, String s, char c) {
        int i = index;
        int j = index;
        int distance = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == c || s.charAt(j) == c) {
                return distance;
            }
            i--;
            j++;
            distance++;
        }
        while (i >= 0) {
            if (s.charAt(i) == c) {
                return distance;
            }
            i--;
            distance++;
        }
        while (j < s.length()) {
            if (s.charAt(j) == c) {
                return distance;
            }
            j++;
            distance++;
        }
        return distance;
    }

    public static void main(String args[]) {
        ShortestDistancetoaCharacter sdtc = new ShortestDistancetoaCharacter();
        System.out.println(Arrays.toString(sdtc.shortestToChar("loveleetcode", 'e')));
    }
}
