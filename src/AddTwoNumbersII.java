
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1r = reverseLinkedList(l1);
        ListNode l2r = reverseLinkedList(l2);
        ListNode result = null;
        int carry = 0;
        while (l1r != null && l2r != null) {
            int l1val = l1r.val;
            int l2val = l2r.val;
            int ans = l1val + l2val + carry;
            carry = 0;
            if (ans > 9) {
                carry = 1;
            }
            ans = ans % 10;
            ListNode node = new ListNode(ans);
            node.next = result;
            result = node;
            l1r = l1r.next;
            l2r = l2r.next;
        }
        while (l1r != null) {
            int l1val = l1r.val;
            int ans = l1val + carry;
            carry = 0;
            if (ans > 9) {
                carry = 1;
            }
            ans = ans % 10;
            ListNode node = new ListNode(ans);
            node.next = result;
            result = node;
            l1r = l1r.next;
        }
        while (l2r != null) {
            int l2val = l2r.val;
            int ans = l2val + carry;
            carry = 0;
            if (ans > 9) {
                carry = 1;
            }
            ans = ans % 10;
            ListNode node = new ListNode(ans);
            node.next = result;
            result = node;
            l2r = l2r.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(1);
            node.next = result;
            result = node;
        }
        return result;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = result;
            result = node;
            head = head.next;
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
