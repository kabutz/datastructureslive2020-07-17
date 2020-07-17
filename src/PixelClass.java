// Good keys:
// 1. implement Comparable
// 2. hashCode as perfect as possible (each distinct object has a distinct hash code)
// e.g. phone number ###-###-#### - standard is ((### * 31) + ###) * 31 + ####
// to make it perfect, do this: ### * 10000000 + ### * 10000 + ####
// 3. hashCode should be as small as possible
// 4. hashCode as fast as possible - no object creation
// 5. equals as fast as possible - no object creation
public class PixelClass implements Pixel, Comparable<PixelClass> {
    private final int x, y;

    public PixelClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PixelClass pixel = (PixelClass) o;

        if (x != pixel.x) return false;
        if (y != pixel.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        // 1920 x 1080
        return x * 1080 + y;
    }

    @Override
    public int compareTo(PixelClass o) {
        int result = Integer.compare(x, o.x);
        if (result != 0) return result;
        return Integer.compare(y, o.y);
    }
}
