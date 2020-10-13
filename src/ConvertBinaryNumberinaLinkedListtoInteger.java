
public class ConvertBinaryNumberinaLinkedListtoInteger {

    public int getDecimalValue(ListNode head) {
        int ans = head.val;
        while (head.next != null) {
            ans = ans * 2 + head.next.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String args[]) {
        ConvertBinaryNumberinaLinkedListtoInteger cbnlli = new ConvertBinaryNumberinaLinkedListtoInteger();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(cbnlli.getDecimalValue(head));
    }
}
