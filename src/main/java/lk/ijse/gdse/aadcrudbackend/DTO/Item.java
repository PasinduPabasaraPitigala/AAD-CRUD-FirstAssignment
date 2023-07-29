package lk.ijse.gdse.aadcrudbackend.DTO;

public class Item {
    private String id;
    private String name;
    private int qty;
    private double price;

    public Item() {
    }

    public Item(String string, String string1, int anInt, double aDouble) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
