import java.util.*;
// javaspecialists.eu
public class ListIterationRace {
    public static void main(String... args) {
        List<Integer> ints = Collections.synchronizedList(new ArrayList<>(100));
        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }

        System.out.println("Starting iterate x 30");

        System.out.println("Test with get()");
        for (int i = 0; i < 10; i++) {
            testWithGet(ints);
        }
        System.out.println("Test with iterator()");
        for (int i = 0; i < 10; i++) {
            testWithIterator(ints);
        }
    }

    private static void testWithGet(List<Integer> ints) {
        long time = System.nanoTime();
        try {
            for (int repeat = 0; repeat < 3000000; repeat++) {
                long total = 0;
                for (int i = 0, upto = ints.size(); i < upto; i++) {
                    total += ints.get(i);
                }
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1000000));
        }
    }

    private static void testWithIterator(List<Integer> ints) {
        long time = System.nanoTime();
        try {
            for (int repeat = 0; repeat < 3000000; repeat++) {
                long total = 0;
                for (Integer anInt : ints) {
                    total += anInt;
                }
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1000000));
        }
    }
}
