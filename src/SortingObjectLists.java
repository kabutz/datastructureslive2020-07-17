import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SortingObjectLists {
    public static void main(String... args) {
        List<String> numbers = ThreadLocalRandom.current()
                .ints(1_000_000).parallel()
                .mapToObj(i -> "" + i).collect(Collectors.toList());

        System.out.println("SortingObjectLists jumbled ArrayList single threaded");
        for (int i = 0; i < 6; i++) {
            List<String> list = new ArrayList<>(numbers);
            sort(() -> list.sort(null));
        }
        System.out.println("SortingObjectLists jumbled ParallelSortingArrayList parallel");
        for (int i = 0; i < 6; i++) {
            ParallelSortingArrayList<String> list =
                    new ParallelSortingArrayList<>(numbers);
            sort(() -> list.parallelSort(null));
        }

        var numbersForSingle = new ArrayList<>(numbers);
        System.out.println("SortingObjectLists sorted ArrayList single threaded");
        numbersForSingle.sort(null);
        for (int i = 0; i < 6; i++) {
            sort(() -> numbersForSingle.sort(null));
        }
        var numbersForParallel = new ParallelSortingArrayList<>(numbers);
        numbersForParallel.sort(null);
        System.out.println("SortingObjectLists sorted ParallelSortingArrayList parallel");
        for (int i = 0; i < 6; i++) {
            sort(() -> numbersForParallel.parallelSort(null));
        }
    }

    private static void sort(Runnable sorter) {
        long time = System.nanoTime();
        try {
            sorter.run();
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
