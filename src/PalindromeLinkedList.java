
import java.util.ArrayList;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(pll.isPalindrome(head));
    }
}
