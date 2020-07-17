import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CSVListFixed extends AbstractCollection<String> {
    private final String[] values;

    public CSVListFixed(String input) {
        values = input.split(",");
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < values.length;
            }

            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                return values[pos++];
            }
        };
    }

    @Override
    public int size() {
        return values.length;
    }
}
