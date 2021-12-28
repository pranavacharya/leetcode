
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast != null) {
            fast = fast.next;
        } else {
            return slow;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return slow;
            }
            fast = fast.next;
            if (fast == null) {
                return slow.next;
            }
        }
        return slow.next;
    }

    public static void main(String args[]) {
        MiddleOfTheLinkedList moll = new MiddleOfTheLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(moll.middleNode(head).val);
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
