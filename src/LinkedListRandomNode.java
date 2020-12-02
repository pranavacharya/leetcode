
public class LinkedListRandomNode {

    private ListNode root;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to
     * be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.root = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int scope = 1;
        int chosenVal = 0;
        ListNode head = this.root;
        while (head != null) {
            if (Math.random() < 1.0 / scope) {
                chosenVal = head.val;
            }
            scope += 1;
            head = head.next;
        }
        return chosenVal;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode llrn = new LinkedListRandomNode(head);
        System.out.println(llrn.getRandom());
    }
}
