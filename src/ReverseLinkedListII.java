
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode startNode = root;
        int startDiff = left - 1;
        while (startDiff > 0 && startNode != null) {
            startNode = startNode.next;
            startDiff--;
        }

        ListNode leftNode = startNode.next;
        int diff = right - left;

        while (diff > 0 && leftNode.next != null) {
            ListNode temp = startNode.next;
            startNode.next = leftNode.next;
            leftNode.next = leftNode.next.next;
            startNode.next.next = temp;
            diff--;
        }
        return root.next;
    }

    public static void main(String args[]) {
        ReverseLinkedListII rll = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(rll.reverseBetween(head, 2, 4));
    }
}
