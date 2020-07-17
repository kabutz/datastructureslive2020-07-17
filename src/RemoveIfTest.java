import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

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

        }
    }
}
