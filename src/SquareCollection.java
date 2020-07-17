import java.util.AbstractCollection;
import java.util.Iterator;

public class SquareCollection extends AbstractCollection<Integer>  {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int pos;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                int current = pos++;
                return current * current;
            }
        };
    }

    @Override
    public int size() {
        return Integer.MAX_VALUE;
    }
}
