
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        if (head.next != null && head.next.next != null) {
            fast = head.next.next;
        } else {
            return false;
        }
        while (fast.next != null && fast.next.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }

    public static void main(String args[]) {
        LinkedListCycle llc = new LinkedListCycle();
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
//        root.next.next.next.next = root.next;
        System.out.println(llc.hasCycle(root));
    }
}
