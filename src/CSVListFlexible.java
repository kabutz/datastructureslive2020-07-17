import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CSVListFlexible extends AbstractCollection<String> {
    private String[] values;

    public CSVListFlexible(String input) {
        values = input.split(",");
    }

    @Override
    public boolean add(String s) {
        String[] newValues = new String[values.length + 1];
        System.arraycopy(values, 0, newValues, 0, values.length);
        newValues[values.length] = s;
        values = newValues;
        return true;
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
