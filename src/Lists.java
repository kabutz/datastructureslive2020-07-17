import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class Lists {
    public static void main(String... args) {
        String[] strings = {"John", "Zach", "Anton"};
        List<String> names = Arrays.asList(strings);
        System.out.println(names.getClass().getSimpleName());
        System.out.println(names.getClass().getName());

//        names.clear();
//        names.add("Heinz");
//        names.remove("John");
        names.set(1, "Heinz");
        System.out.println("names = " + names);

        strings[1] = "Dirk";
        System.out.println("names = " + names);

        List<String> names2 = List.of("Betsie", "Prashni", "Helene");

        // RandomAccess:
        // Vector, ArrayList, Arrays$ArrayList, List.of(), CopyOnWriteArrayList

        // Not RandomAccess:
        // LinkedList
    }
}
