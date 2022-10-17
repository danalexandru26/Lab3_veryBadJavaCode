package Products;

public class Typewriter extends Product{
    int pagesPerMinute;

    public Typewriter(String name, String storeZone, String state, double price, int pagesPerMinute) {
        super(name, storeZone, state, price);
        this.pagesPerMinute = pagesPerMinute;
    }

    @Override
    public String toString() {
     return String.format("%s \nPages/minute: %d", super.toString(), pagesPerMinute);
    }
}
