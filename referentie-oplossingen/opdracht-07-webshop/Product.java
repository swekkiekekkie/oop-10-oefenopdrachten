public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        // EDGE CASE: Prijs mag niet negatief zijn
        this.price = Math.max(0.0, price);
        // EDGE CASE: Voorraad mag niet negatief zijn
        this.stock = Math.max(0, stock);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Product weet zelf of er voorraad is voor N stuks
    public boolean hasStockFor(int quantity) {
        // EDGE CASE: Negatief aantal
        if (quantity < 0) {
            return false;
        }
        return stock >= quantity;
    }

    // Product beheert eigen voorraad
    public boolean reduceStock(int quantity) {
        // EDGE CASE: Niet genoeg voorraad
        if (!hasStockFor(quantity)) {
            return false;
        }
        stock -= quantity;
        return true;
    }

    public void addStock(int quantity) {
        // EDGE CASE: Negatieve toevoeging negeren
        if (quantity > 0) {
            stock += quantity;
        }
    }
}
