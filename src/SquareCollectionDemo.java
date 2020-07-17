import java.util.Collection;

public class SquareCollectionDemo {
    public static void main(String... args) {
        Collection<Integer> squares = new SquareCollection();
        squares.stream().limit(101).forEach(System.out::println);
    }
}
