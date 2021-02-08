
import java.util.Iterator;

public class PeekingIterator {

    private Iterator<Integer> iterator;
    private boolean isPeeked;
    private Integer peaked;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!this.isPeeked) {
            this.isPeeked = true;
            this.peaked = this.iterator.next();
        }
        return this.peaked;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!this.isPeeked) {
            return this.iterator.next();
        } else {
            Integer result = this.peaked;
            this.isPeeked = false;
            this.peaked = null;
            return result;
        }
    }

    @Override
    public boolean hasNext() {
        return this.isPeeked || this.iterator.hasNext();
    }
}
