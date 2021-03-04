
public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null && headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String args[]) {
        IntersectionOfTwoLinkedList itll = new IntersectionOfTwoLinkedList();
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(itll.getIntersectionNode(headA, headB).val);
    }
}
