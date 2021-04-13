
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator implements Iterator<Integer> {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private Stack<Integer> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.pushToStack(nestedList.get(i), stack);
        }
    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    private void pushToStack(NestedInteger ni, Stack<Integer> stack) {
        if (ni.isInteger()) {
            stack.push(ni.getInteger());
        } else {
            List<NestedInteger> sub = ni.getList();
            for (int i = sub.size() - 1; i >= 0; i--) {
                pushToStack(sub.get(i), stack);
            }
        }
    }
}
