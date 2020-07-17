import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntFunction;

public class PixelDemo {
    interface PixelCreator {
        Pixel create(int x, int y);
    }
    public static void main(String... args) {
        PixelCreator creator = PixelClass::new;
        List<Pixel> pixels = new ArrayList<>();
        long time = System.nanoTime();
        try {
            for (int x = 0; x < 1920; x++) {
                for (int y = 0; y < 1080; y++) {
                    pixels.add(creator.create(x, y));
                }
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
        System.out.println("Adding pixels to map");

//        System.out.println("1920x1080=" + 1920 * 1080);
//        System.out.println(pixels.stream().mapToInt(Object::hashCode)
//                .distinct().count());

        HashMap<Pixel, Pixel> pixelMap = new HashMap<>();
        time = System.nanoTime();
        try {
            for (Pixel pixel : pixels) {
                pixelMap.put(pixel, pixel);
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }

        System.out.println("Checking map");
        for (int x = 0; x < 1920; x++) {
            for (int y = 0; y < 1080; y++) {
                if (!pixelMap.containsKey(creator.create(x, y)))
                    throw new AssertionError();
            }
        }

        System.out.println("Looking up pixels");
        for (int i = 0; i < 30; i++) {
            testLookup(pixels, pixelMap);
        }
    }

    private static void testLookup(List<Pixel> pixels, HashMap<Pixel, Pixel> pixelMap) {
        long time = System.nanoTime();
        try {
            for (int i = 0; i < 10; i++) {
                for (Pixel pixel : pixels) {
                    if (!pixelMap.containsKey(pixel)) throw new AssertionError();
                }
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
