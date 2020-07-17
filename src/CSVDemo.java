import java.util.Collection;

public class CSVDemo {
    public static void main(String... args) {
        Collection<String> heinz = new CSVListFlexible(
                "Heinz,Kabutz,heinz@javaspecialists.eu,Chorafakia,Crete,Greece");
        System.out.println(heinz);

        heinz.stream().filter(val -> val.contains("@"))
                .forEach(System.out::println);

        heinz.add("Earth");
        System.out.println(heinz);

        System.out.println("heinz.size() = " + heinz.size());
    }
}
