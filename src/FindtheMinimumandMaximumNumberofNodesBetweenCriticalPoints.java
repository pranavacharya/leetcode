
import java.util.Arrays;

public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int firstIndex = -1;
        int last = -1;

        int lastVal = head.val;
        head = head.next;
        int index = 0;

        int max = 0;
        int min = Integer.MAX_VALUE;

        while (head.next != null) {
            if ((head.val > lastVal && head.val > head.next.val) || (head.val < lastVal && head.val < head.next.val)) {
                if (firstIndex == -1) {
                    firstIndex = index;
                }
                max = Math.max(max, index - firstIndex);
                if (last != -1) {
                    min = Math.min(min, index - last);
                }
                last = index;
            }
            index++;
            lastVal = head.val;
            head = head.next;
        }

        max = max == 0 ? -1 : max;
        min = min == Integer.MAX_VALUE ? -1 : min;
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints fmamnnbcp = new FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints();
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);
        System.out.println(Arrays.toString(fmamnnbcp.nodesBetweenCriticalPoints(head)));
    }
}
