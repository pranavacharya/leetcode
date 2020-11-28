
public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int diff = b - a + 1;
        ListNode head = list1;

        while (head != null) {
            a--;
            if (a == 0) {
                break;
            }
            head = head.next;
        }
        ListNode next = head.next;

        head.next = list2;
        while (head.next != null) {
            head = head.next;
        }

        while (next != null) {
            next = next.next;
            diff--;
            if (diff == 0) {
                break;
            }
        }
        head.next = next;
        return list1;
    }

    public static void main(String args[]) {
        MergeInBetweenLinkedLists mibll = new MergeInBetweenLinkedLists();
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        ListNode l2 = new ListNode(100);
        l2.next = new ListNode(101);
        System.out.println(mibll.mergeInBetween(l1, 3, 4, l2));
    }
}
