package Products;

import Enums.OS;

public class Computer extends  Product {
    double cpuClock;
    double storageCapacity;
    OS operatingSystem;

    public Computer(String name, String storeZone, String state, double price, double clock, double storage, String os) {
        super(name, storeZone, state, price);
        cpuClock = clock;
        storageCapacity = storage;
        operatingSystem = OS.valueOf(os);
    }

    @Override
    public void setMode(String newMode) {
        operatingSystem = OS.valueOf(newMode);
    }

    @Override
    public String toString() {
        return String.format("%s \nCPU clock(in Ghz): %f \nStorage capacity(in GB): %f \nOperating system: %s",
                super.toString(), cpuClock, storageCapacity, operatingSystem.toString());
    }
}
