import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class SortingPrimitives {
    public static void main(String... args) {
        int[] numbers = ThreadLocalRandom.current()
                .ints(10_000_000).parallel().toArray();

        System.out.println("SortingPrimitives jumbled int[] single threaded");
        for (int i = 0; i < 6; i++) {
            sort(numbers.clone(), Arrays::sort);
        }
        System.out.println("SortingPrimitives jumbled int[] parallel");
        for (int i = 0; i < 6; i++) {
            sort(numbers.clone(), Arrays::parallelSort);
        }

        int[] numbersForSingle = numbers.clone();
        System.out.println("SortingPrimitives sorted int[] single threaded");
        Arrays.parallelSort(numbersForSingle);
        for (int i = 0; i < 6; i++) {
            sort(numbersForSingle, Arrays::sort);
        }
        int[] numbersForParallel = numbers.clone();
        Arrays.sort(numbersForParallel);
        System.out.println("SortingPrimitives sorted int[] parallel");
        for (int i = 0; i < 6; i++) {
            sort(numbersForParallel, Arrays::parallelSort);
        }
    }

    private static void sort(int[] numbers, Consumer<int[]> sorter) {
        long time = System.nanoTime();
        try {
            sorter.accept(numbers);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
