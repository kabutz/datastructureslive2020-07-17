import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveIfTest {
    public static void main(String... args) {
        {
            System.out.println("Vector with Enumeration");
            Vector<String> items = new Vector<>();
            Collections.addAll(items, "suncream", "hat", "raki",
                    "razor", "beach bats", "rage");
            Enumeration<String> en = items.elements();
            while (en.hasMoreElements()) {
                String item = en.nextElement();
                if (item.startsWith("ra")) items.remove(item);
            }
            System.out.println(items);
        }
        {
            try {
                System.out.println("Vector with Iterator - fail fast");
                Vector<String> items = new Vector<>();
                Collections.addAll(items, "suncream", "hat", "raki",
                        "razor", "beach bats", "rage");
                Iterator<String> it = items.iterator();
                while (it.hasNext()) {
                    String item = it.next();
                    if (item.startsWith("ra")) items.remove(item);
                }
                System.out.println(items);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        {
            try {
                System.out.println("HashSet with Iterator - fail fast");
                Collection<String> items = new HashSet<>();
                Collections.addAll(items, "suncream", "hat", "raki",
                        "razor", "beach bats", "rage");
                Iterator<String> it = items.iterator();
                while (it.hasNext()) {
                    String item = it.next();
                    if (item.startsWith("ra")) items.remove(item);
                }
                System.out.println(items);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        {
            System.out.println("Vector with Iterator.remove()");
            Vector<String> items = new Vector<>();
            Collections.addAll(items, "suncream", "hat", "raki",
                    "razor", "beach bats", "rage");
            Iterator<String> it = items.iterator();
            while (it.hasNext()) {
                String item = it.next();
                if (item.startsWith("ra")) it.remove();
            }
            System.out.println(items);
        }
        {
            System.out.println("CopyOnWriteArrayList with Iterator");
            List<String> items = new CopyOnWriteArrayList<>();
            Collections.addAll(items, "suncream", "hat", "raki",
                    "razor", "beach bats", "rage");
            Iterator<String> it = items.iterator();
            while (it.hasNext()) {
                String item = it.next();
                if (item.startsWith("ra")) items.remove(item);
            }
            System.out.println(items);
        }

        {
            System.out.println("Removing from ArrayList with Iterator");
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < 400_000; i++) {
                numbers.add(i);
            }
            long time = System.nanoTime();
            try {
                for (Iterator<Integer> it = numbers.iterator(); it.hasNext(); ) {
                    Integer next = it.next();
                    if (next % 2 == 0) it.remove();
                }
                System.out.println("numbers.size() = " + numbers.size());
            } finally {
                time = System.nanoTime() - time;
                System.out.printf("time = %dms%n", (time / 1_000_000));
            }
        }
        {
            System.out.println("Removing from LinkedList with Iterator");
            List<Integer> numbers = new LinkedList<>();
            for (int i = 0; i < 400_000; i++) {
                numbers.add(i);
            }
            long time = System.nanoTime();
            try {
                for (Iterator<Integer> it = numbers.iterator(); it.hasNext(); ) {
                    Integer next = it.next();
                    if (next % 2 == 0) it.remove();
                }
                System.out.println("numbers.size() = " + numbers.size());
            } finally {
                time = System.nanoTime() - time;
                System.out.printf("time = %dms%n", (time / 1_000_000));
            }
        }

        {
            System.out.println("Removing from ArrayList with removeIf");
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < 400_000; i++) {
                numbers.add(i);
            }
            long time = System.nanoTime();
            try {
                numbers.removeIf(number -> number % 2 == 0);
                System.out.println("numbers.size() = " + numbers.size());
            } finally {
                time = System.nanoTime() - time;
                System.out.printf("time = %dms%n", (time / 1_000_000));
            }
        }

    }
}
