
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = root;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        LinkedListCycleII llc = new LinkedListCycleII();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode node = llc.detectCycle(head);
        System.out.println(node.val);
    }
}
