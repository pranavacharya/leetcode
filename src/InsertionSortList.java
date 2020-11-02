
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode();
        while (head != null) {
            ListNode temp = head.next;
            ListNode prev = root;
            ListNode next = root.next;
            while (next != null) {
                if (next.val > head.val) {
                    break;
                }
                prev = next;
                next = next.next;
            }

            head.next = next;
            prev.next = head;
            head = temp;
        }
        return root.next;
    }

    public static void main(String args[]) {
        InsertionSortList isl = new InsertionSortList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        System.out.println(isl.insertionSortList(head));
    }
}
