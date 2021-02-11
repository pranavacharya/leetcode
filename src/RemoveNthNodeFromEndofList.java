
import java.util.LinkedList;
import java.util.Queue;

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        Queue<ListNode> queue = new LinkedList();
        while (head != null) {
            queue.add(head);
            if (queue.size() > n + 1) {
                queue.poll();
            }
            head = head.next;
        }
        if (queue.size() != n + 1) {
            return root.next;
        }
        head = queue.poll();
        if (head.next != null) {
            head.next = head.next.next;
        }
        return root;
    }

    public static void main(String args[]) {
        RemoveNthNodeFromEndofList rnnfel = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(rnnfel.removeNthFromEnd(head, 5));
    }
}
