
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        ListNode ans;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        size = (size / 2);
        ans = head;
        while (size > 0) {
            ans = ans.next;
            size--;
        }
        return ans;
    }

    public static void main(String args[]) {
        MiddleOfTheLinkedList moll = new MiddleOfTheLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(moll.middleNode(head).val);
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
