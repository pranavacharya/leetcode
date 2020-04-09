
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = reverse;
            reverse = temp;
            head = head.next;
        }
        return reverse;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String args[]) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        rll.printList(rll.reverseList(head));
    }
}
