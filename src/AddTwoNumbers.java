
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(-1);
        ListNode head = sum;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            temp += carry;
            carry = 0;
            if (temp > 9) {
                temp = temp % 10;
                carry = 1;
            }
            sum.next = new ListNode(temp);
            sum = sum.next;
        }
        return head.next;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
