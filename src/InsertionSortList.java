
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            int val = head.val;
            ListNode temp = root;
            while (temp.next != null && temp.next.val < val) {
                temp = temp.next;
            }
            if (temp.next == null || temp.val > val) {
                if (temp.val > val) {
                    ListNode node = new ListNode(val);
                    node.next = temp;
                    if (temp == root) {
                        root = node;
                    }
                } else {
                    temp.next = new ListNode(val);
                }
            } else {
                ListNode node = new ListNode(val);
                node.next = temp.next;
                temp.next = node;
            }
            head = head.next;
        }

        return root;
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
