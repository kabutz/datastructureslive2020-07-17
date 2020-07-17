import java.util.Arrays;
import java.util.function.Consumer;

public class SortingParallelVsSequential {
    public static void main(String... args) {
        int[] ints = new int[200_000_000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        System.out.println("Single threaded sort");
        for (int i = 0; i < 10; i++) {
            test(ints, Arrays::sort);
        }
        System.out.println("Parallel sort");
        for (int i = 0; i < 10; i++) {
            test(ints, Arrays::parallelSort);
        }
    }

    private static void test(int[] ints, Consumer<int[]> sorter) {
        long time = System.nanoTime();
        try {
            sorter.accept(ints);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }

    }
}
