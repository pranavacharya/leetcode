
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long first = 0;
        while (l1 != null) {
            first = first * 10 + l1.val;
            l1 = l1.next;
        }
        long second = 0;
        while (l2 != null) {
            second = second * 10 + l2.val;
            l2 = l2.next;
        }
        long ans = first + second;
        if (ans == 0) {
            return new ListNode(0);
        }
        ListNode result = null;
        while (ans > 0) {
            long digit = ans % 10;
            ListNode node = new ListNode((int) digit);
            node.next = result;
            result = node;
            ans /= 10;
        }
        return result;
    }

    public static void main(String args[]) {
        AddTwoNumbersII atn = new AddTwoNumbersII();
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(atn.addTwoNumbers(l1, l2));
    }
}
