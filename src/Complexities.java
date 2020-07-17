import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Supplier;

public class Complexities {
    public static void main(String... args) {
        // O(1) // constant // ArrayList.get(n)
        // O(n) // linear // LinkedList.get(n) // ArrayList.remove(0)
        // O(log n) // logarithmic // TreeSet.add()
        // O(n * log n) // quasilinear // Merge Sort

        // O(n^2) // quadratic // BigInteger.multiply() prior to Java 8 // Bubble Sort

        // node/links or arrays

        testAllocate("int[]", () -> new int[10_000_000]);
        testAllocate("ArrayList<Int> 0 ", () -> {
            List<Integer> result = new ArrayList<>(10_000_000);
            for (int i = 0; i < 10_000_000; i++) {
                result.add(0);
            }
            return result;
        });
        testAllocate("ArrayList<Int> 1000 ", () -> {
            List<Integer> result = new ArrayList<>(10_000_000);
            for (int i = 0; i < 10_000_000; i++) {
                result.add(1000);
            }
            return result;
        });
        testAllocate("LinkedList<Int> 0 ", () -> {
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < 10_000_000; i++) {
                result.add(0);
            }
            return result;
        });
        testAllocate("LinkedList<Int> 1000 ", () -> {
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < 10_000_000; i++) {
                result.add(Integer.valueOf(1000));
            }
            return result;
        });
    }

    private static void testAllocate(String type, Supplier<Object> allocater) {
        new Thread(
                () -> {
                    Object o = allocater.get();
                    LockSupport.park();
                }, type + " allocating thread"
        ).start();
    }
}
