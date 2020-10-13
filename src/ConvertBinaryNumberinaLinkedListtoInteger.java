
public class ConvertBinaryNumberinaLinkedListtoInteger {

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String args[]) {
        ConvertBinaryNumberinaLinkedListtoInteger cbnlli = new ConvertBinaryNumberinaLinkedListtoInteger();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(cbnlli.getDecimalValue(head));
    }
}
