import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class SortingObjects {
    public static void main(String... args) {
        String[] numbers = ThreadLocalRandom.current()
                .ints(1_000_000).parallel()
                .mapToObj(i -> "" + i).toArray(String[]::new);

        System.out.println("SortingObjects jumbled String[] single threaded");
        for (int i = 0; i < 6; i++) {
            sort(numbers.clone(), Arrays::sort);
        }
        System.out.println("SortingObjects jumbled String[] parallel");
        for (int i = 0; i < 6; i++) {
            sort(numbers.clone(), Arrays::parallelSort);
        }

        String[] numbersForSingle = numbers.clone();
        System.out.println("SortingObjects sorted String[] single threaded");
        Arrays.parallelSort(numbersForSingle);
        for (int i = 0; i < 6; i++) {
            sort(numbersForSingle, Arrays::sort);
        }
        String[] numbersForParallel = numbers.clone();
        Arrays.sort(numbersForParallel);
        System.out.println("SortingObjects sorted String[] parallel");
        for (int i = 0; i < 6; i++) {
            sort(numbersForParallel, Arrays::parallelSort);
        }
    }

    private static void sort(String[] numbers, Consumer<String[]> sorter) {
        long time = System.nanoTime();
        try {
            sorter.accept(numbers);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
