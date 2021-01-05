
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode root = ans;
        while (head != null) {
            if (occurence(head) > 1) {
                ListNode temp = head;
                while (head != null && head.val == temp.val) {
                    head = head.next;
                }
            } else {
                ans.next = new ListNode(head.val);
                ans = ans.next;
                head = head.next;
            }
        }
        return root.next;
    }

    private int occurence(ListNode head) {
        int count = 0;
        ListNode root = head;
        while (head != null && root.val == head.val) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String args[]) {
        RemoveDuplicatesfromSortedListII rdsl = new RemoveDuplicatesfromSortedListII();
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(3);
        System.out.println(rdsl.deleteDuplicates(root));
    }
}
