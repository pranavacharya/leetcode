
import java.util.Random;

public class LinkedListRandomNode {

    private int length;
    private ListNode root;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to
     * be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.root = head;
        this.length = 0;
        while (head != null) {
            this.length++;
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        Random rand = new Random();
        int number = rand.nextInt(this.length);
        ListNode head = this.root;
        while (head != null) {
            if (number == 0) {
                return head.val;
            }
            number--;
            head = head.next;
        }
        return head.val;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode llrn = new LinkedListRandomNode(head);
        System.out.println(llrn.getRandom());
    }
}
