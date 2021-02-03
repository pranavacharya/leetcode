
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode slow = head;
            ListNode fast = head;
            fast = head.next.next;

            while (!(fast.next == null || fast.next.next == null)) {
                if (slow == fast) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        LinkedListCycle llc = new LinkedListCycle();
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = root.next;
        System.out.println(llc.hasCycle(root));
    }
}
