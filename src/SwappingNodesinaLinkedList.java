
public class SwappingNodesinaLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        int size = sizeLinkedList(head);
        ListNode first = firstNNode(head, k);
        ListNode second = firstNNode(head, size - k + 1);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }

    private int sizeLinkedList(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private ListNode firstNNode(ListNode head, int k) {
        while (head != null && k > 1) {
            k--;
            head = head.next;
        }
        return head;
    }

    public static void main(String args[]) {
        SwappingNodesinaLinkedList snll = new SwappingNodesinaLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(snll.swapNodes(head, 2));
    }
}
