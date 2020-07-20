
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        ans = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        RemoveLinkedListElements rle = new RemoveLinkedListElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        System.out.println(rle.removeElements(head, 6));
    }
}
