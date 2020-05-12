
import java.util.ArrayList;

public class RemoveZeroSumConsecutiveNodesfromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> result = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] prefixsum = new int[list.size() + 1];
        prefixsum[0] = 0;
        for (int i = 1; i < prefixsum.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + list.get(i - 1);
        }
        for (int i = 0; i < prefixsum.length; i++) {
            for (int j = i + 1; j < prefixsum.length; j++) {
                if (prefixsum[j] - prefixsum[i] == 0) {
                    for (int k = i; k <= j - 1; k++) {
                        list.set(k, 0);
                    }
                    i = j - 1;
                    break;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                result.add(list.get(i));
            }
        }
        ListNode ans = null;
        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                head = new ListNode(result.get(0));
                ans = head;
            } else {
                ListNode temp = new ListNode(result.get(i));
                head.next = temp;
                head = head.next;
            }
        }
        System.out.println(result);
        return ans;
    }

    public static void main(String args[]) {
        RemoveZeroSumConsecutiveNodesfromLinkedList rzscnfll = new RemoveZeroSumConsecutiveNodesfromLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        System.out.println(rzscnfll.removeZeroSumSublists(head));
    }
}
