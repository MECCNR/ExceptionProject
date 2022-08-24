public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String toString() {
        return id + " " + name + " " + price + " " + manufacturer;
    }
}
