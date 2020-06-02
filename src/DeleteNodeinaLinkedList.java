
public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        while (node.next != null) {
            int temp = node.next.val;
            node.val = temp;
            if (node.next.next != null) {
                node = node.next;
            } else {
                node.next = null;
            }
        }
    }

    public static void main(String args[]) {
        DeleteNodeinaLinkedList dnil = new DeleteNodeinaLinkedList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        dnil.deleteNode(head.next);
    }
}
