
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(head.next.val);
        temp.next = head;
        head.next = head.next.next;
        if (head.next != null && head.next.next != null) {
            head.next = swapPairs(head.next);
        }
        return temp;
    }

    public static void main(String args[]) {
        SwapNodesinPairs snp = new SwapNodesinPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head = snp.swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
