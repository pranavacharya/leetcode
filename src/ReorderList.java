
import java.util.Stack;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stack = new Stack();
        ListNode current = slow.next;
        slow.next = null;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = head;
        while (stack.size() > 0) {
            stack.peek().next = current.next;
            current.next = stack.pop();
            current = current.next.next;
        }
    }

    public static void main(String args[]) {
        ReorderList rl = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        rl.reorderList(head);
        System.out.println(head);
    }
}
