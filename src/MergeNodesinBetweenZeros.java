
public class MergeNodesinBetweenZeros {
    
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode last = head;
        ListNode ans = new ListNode(-1);
        ListNode ansHead = ans;
        int sum = 0;
        while(temp != null) {
            int val = temp.val;
            if(val == 0) {
                ListNode between = new ListNode(sum);
                ansHead.next = between;
                ansHead = ansHead.next;
                sum = 0;
            } else {
                sum += val;
            }
            temp = temp.next;
        }
        return ans.next;
    }
    
    public static void main(String[] args) {
        MergeNodesinBetweenZeros mnbz = new MergeNodesinBetweenZeros();
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        System.out.println(mnbz.mergeNodes(head));
    }
}
