import java.util.Objects;

public record PixelRecord(int x, int y) implements Pixel, Comparable<PixelRecord> {
    // tinyurl.com/ArrayList2020
    @Override
    public int hashCode() {
        // 1920 x 1080
        return x * 1080 + y;
    }
    @Override
    public int compareTo(PixelRecord o) {
        int result = Integer.compare(x, o.x);
        if (result != 0) return result;
        return Integer.compare(y, o.y);
    }
}