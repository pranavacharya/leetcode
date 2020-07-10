
import java.util.Stack;

public class FlattenaMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) {
            return new Node();
        }
        Node ans = new Node();
        Node pointer = ans;
        Stack<Node> stack = new Stack();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node curr = stack.pop(); //element to start with

            // traverse the list and add it to ans 
            // if child node present, put next node in the stack and make child node the current node
            while (curr != null) {
                Node temp = new Node();
                temp.val = curr.val;
                temp.prev = pointer;
                temp.next = null;

                pointer.next = temp;

                pointer = pointer.next;

                if (curr.child != null) {
                    stack.add(curr.next);
                    curr = curr.child;
                } else {
                    curr = curr.next;
                }
            }
        }
        ans = ans.next;
        ans.prev = null;
        return ans;
    }
}
