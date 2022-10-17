package Products;

import Enums.State;

public class Product {
    String name;
    String storeZone;
    int inventoryId;
    double price;
    State state;
    static int ID = 0;

    private Product() {
    }

    public Product(String name, String storeZone, String state, double price) {
        this.name = name;
        this.storeZone = storeZone;
        this.inventoryId = ID;
        this.price = price;
        this.state = State.valueOf(state);
        ++ID;
    }

    public void setMode(String newState){}

    public void setState(String newState) {
        state = State.valueOf(newState);
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \nStore zone: %s \nInventory ID: %d \nPrice: %f \nProduct availability: %s",
                name, storeZone, inventoryId, price, state.toString());
    }
}
