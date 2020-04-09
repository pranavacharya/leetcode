
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverse = new ListNode(head.val);
        reverse.next = null;
        while (head.next != null) {
            head = head.next;
            ListNode temp = new ListNode(head.val);
            temp.next = reverse;
            reverse = temp;
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
        System.out.println(head.val);
        while (head.next != null) {
            head = head.next;
            System.out.println(head.val);
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
