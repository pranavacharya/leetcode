
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        temp = head;
        for (int i = 1; i < size - k; i++) {
            temp = temp.next;
        }
        ListNode start = temp.next;
        temp.next = null;
        temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return start;
    }

    public static void main(String args[]) {
        RotateList rl = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = rl.rotateRight(head, 2);
        System.out.println(head);
    }
}
