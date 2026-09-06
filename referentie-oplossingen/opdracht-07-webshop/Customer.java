public class Customer {
    private String name;
    private int age;
    private ShoppingCart cart;

    public Customer(String name, int age) {
        this.name = name;
        // EDGE CASE: Leeftijd mag niet negatief zijn
        this.age = Math.max(0, age);
        this.cart = new ShoppingCart();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    // Customer weet zelf of hij/zij volwassen is
    public boolean isAdult() {
        return age >= 18;
    }

    // Voegt item toe aan eigen winkelwagen
    public void addToCart(Product product, int quantity) {
        // EDGE CASE: Geen product of ongeldig aantal
        if (product == null || quantity <= 0) {
            return;
        }
        ShoppingCartItem item = new ShoppingCartItem(quantity, product);
        cart.addItem(item);
    }

    // Delegeert aan winkelwagen voor totaal
    public double getCartTotal() {
        return cart.calculateTotal();
    }
}
