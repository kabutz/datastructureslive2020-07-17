import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadedSets {
    public static void main(String... args) {
//        test(new ConcurrentSkipListSet<>());
//        test(new TreeSet<>());
//        test(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            test(ConcurrentHashMap.newKeySet());
        }
    }

    private static void test(Set<Integer> numbers) {
        long time = System.nanoTime();
        try {
            try {
                System.out.println(numbers.getClass());
                ThreadLocalRandom.current().ints(3_000_000)
                        .parallel().forEach(numbers::add);
                System.out.println("OK");
            } catch (Exception e) {
                System.out.println(e);
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
