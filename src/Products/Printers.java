package Products;

import Enums.PrinterModes;

public class Printers extends Typewriter {
    double resolution;
    int pagesPerCartridge;
    PrinterModes mode;

    public Printers(String name, String storeZone, String state, double price, int pagesPerMinute, double resolution, int pagesPerCartridge, String mode) {
        super(name, storeZone, state, price, pagesPerMinute);
        this.resolution = resolution;
        this.pagesPerCartridge = pagesPerCartridge;
        this.mode = PrinterModes.valueOf(mode);
    }

    public void setMode(String newMode) {
        mode = PrinterModes.valueOf(newMode);
    }

    @Override
    public String toString() {
        return String.format("%s \nResolution: %f \nPages/Cartridge: %d \nMode: %s ", super.toString(), resolution, pagesPerCartridge, mode.toString());
    }
}
