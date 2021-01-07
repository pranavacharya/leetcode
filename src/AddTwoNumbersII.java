
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sizel1 = 0;
        ListNode temp = l1;
        while (temp != null) {
            temp = temp.next;
            sizel1++;
        }

        int sizel2 = 0;
        temp = l2;
        while (temp != null) {
            temp = temp.next;
            sizel2++;
        }

        int size = Math.max(sizel1, sizel2);
        int carry = 0;

        ListNode ans = null;

        while (size > 0) {

            int sum = 0;

            sum += findNthNode(l1, sizel1);

            sum += findNthNode(l2, sizel2);

            sum += carry;

            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }

            // System.out.println(sum);
            ListNode node = new ListNode(sum % 10);

            node.next = ans;
            ans = node;

            size--;
            sizel1--;
            sizel2--;
        }

        if (carry != 0) {
            ListNode node = new ListNode(1);
            node.next = ans;
            ans = node;
        }

        return ans;
    }

    private int findNthNode(ListNode l, int n) {
        int count = 1;
        while (l != null && count != n) {
            l = l.next;
            count++;
        }
        if (l != null) {
            return l.val;
        }
        return 0;
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
