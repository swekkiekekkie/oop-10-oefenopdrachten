public class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        // EDGE CASE: Prijs mag niet negatief zijn
        this.price = Math.max(0.0, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
