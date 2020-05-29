
import java.util.Arrays;

public class HandofStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        Arrays.sort(hand);
        for (int j = 0; j < hand.length / W; j++) {
            int count = 0;
            int last = -1;
            for (int i = 0; i < hand.length && count < W; i++) {
                if (hand[i] < 0 || hand[i] == last) {
                    continue;
                } else if (last != -1 && hand[i] != last + 1) {
                    return false;
                } else {
                    last = hand[i];
                    hand[i] = -1;
                    count++;
                }
            }
            if (count != W) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        HandofStraights hs = new HandofStraights();
        int[] hand = new int[]{1, 1, 2, 2, 3, 3};
//        int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(hs.isNStraightHand(hand, 2));
    }
}
