import java.util.Map;

public class HashingFundamentals {
    static class Hashtable<K, V> {
        private Map.Entry<K, V>[] entries = new Map.Entry[1024];
        private int mask = entries.length - 1;

        private static int hash(int h) {

            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }

        public V put(K key, V value) {
            int position = (key.hashCode() & mask);
            // if there is something there, what now?
            Map.Entry<K, V> found = entries[position];
            if (found != null) {
                if (key.equals(found.getKey())) {
                    entries[position] = Map.entry(key, value);
                    return found.getValue();
                } else {
                    // create linked list of nodes
                    return null;
                }
            }
            entries[position] = Map.entry(key, value);
            return null;
        }
    }

    public static void main(String... args) {

    }
}
