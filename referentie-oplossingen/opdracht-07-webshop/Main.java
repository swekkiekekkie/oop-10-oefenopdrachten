public class Main {
    public static void main(String[] args) {
        // Creëer producten
        Product laptop = new Product("MacBook Pro", 2499.00, 5);
        Product phone = new Product("iPhone 15", 1199.00, 10);
        Product headphones = new Product("AirPods Pro", 279.00, 20);
        Product charger = new Product("USB-C Charger", 29.99, 100);

        System.out.println("=== Webshop Assortiment ===");
        System.out.println(laptop.getName() + " - €" + laptop.getPrice() + " (voorraad: " + laptop.getStock() + ")");
        System.out.println(phone.getName() + " - €" + phone.getPrice() + " (voorraad: " + phone.getStock() + ")");
        System.out.println(headphones.getName() + " - €" + headphones.getPrice() + " (voorraad: " + headphones.getStock() + ")");
        System.out.println(charger.getName() + " - €" + charger.getPrice() + " (voorraad: " + charger.getStock() + ")");
        System.out.println();

        // Creëer klant
        Customer customer = new Customer("Jan de Vries", 25);
        System.out.println("--- Klant ---");
        System.out.println("Naam: " + customer.getName());
        System.out.println("Leeftijd: " + customer.getAge());
        System.out.println("Is volwassen: " + customer.isAdult());
        System.out.println();

        // Voeg producten toe aan winkelwagen
        System.out.println("--- Winkelen ---");
        customer.addToCart(laptop, 1);
        System.out.println("1x " + laptop.getName() + " toegevoegd");
        
        customer.addToCart(phone, 2);
        System.out.println("2x " + phone.getName() + " toegevoegd");
        
        customer.addToCart(headphones, 1);
        System.out.println("1x " + headphones.getName() + " toegevoegd");
        System.out.println();

        // Toon winkelwagen
        ShoppingCart cart = customer.getCart();
        System.out.println("--- Winkelwagen ---");
        System.out.println("Aantal items: " + cart.getItemCount());
        System.out.println("Totaal producten: " + cart.getTotalProducts());
        System.out.println();
        
        for (ShoppingCartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName());
            System.out.println("  Stukprijs: €" + item.getProduct().getPrice());
            System.out.println("  Regeltotaal (via delegatie): €" + item.calculateLineTotal());
            System.out.println("  Genoeg voorraad: " + item.hasEnoughStock());
        }
        System.out.println();

        // Delegatie demonstratie
        System.out.println("--- Delegatieketen ---");
        System.out.println("Customer vraagt winkelwagentotaal:");
        System.out.println("  Customer → Cart.calculateTotal()");
        System.out.println("  Cart → elke ShoppingCartItem.calculateLineTotal()");
        System.out.println("  ShoppingCartItem → Product.getPrice()");
        System.out.printf("  Totaal: €%.2f%n", customer.getCartTotal());
        System.out.println();

        // Product voorraadcheck (EDGE CASE demonstratie)
        System.out.println("--- Voorraad check (delegatie) ---");
        System.out.println("Product weet zelf of er voorraad is:");
        System.out.println("  laptop.hasStockFor(3): " + laptop.hasStockFor(3));
        System.out.println("  laptop.hasStockFor(10): " + laptop.hasStockFor(10));
        System.out.println();

        // Checkout check
        System.out.println("--- Checkout ---");
        System.out.println("Kan afrekenen (alle items op voorraad): " + cart.canCheckout());
        System.out.printf("Totaalbedrag: €%.2f%n", cart.calculateTotal());
        System.out.println();

        // EDGE CASE: Minderjarige klant
        System.out.println("--- EDGE CASE: Minderjarige klant ---");
        Customer youngCustomer = new Customer("Emma", 16);
        System.out.println("Klant: " + youngCustomer.getName() + ", " + youngCustomer.getAge() + " jaar");
        System.out.println("Is volwassen: " + youngCustomer.isAdult());
    }
}
