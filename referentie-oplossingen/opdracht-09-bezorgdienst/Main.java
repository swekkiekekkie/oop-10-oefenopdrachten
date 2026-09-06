public class Main {
    public static void main(String[] args) {
        // Creëer bezorgdienst
        DeliveryService service = new DeliveryService("PostNL Express");
        System.out.println("=== " + service.getName() + " ===");
        System.out.println();

        // Bezorging 1: Licht pakket, korte afstand
        System.out.println("--- Bezorging 1: Licht pakket ---");
        Address address1 = new Address("Damrak", "1", "Amsterdam");
        Package package1 = new Package(2.5);  // 2.5 kg
        Delivery delivery1 = new Delivery(5.00, 10.0, package1, address1);
        
        System.out.println("Adres (via delegatie): " + delivery1.getDeliveryAddress());
        System.out.println("Pakketgewicht: " + package1.getWeight() + " kg");
        System.out.println("Package bepaalt zelf of het zwaar is: " + package1.isHeavy());
        System.out.println();
        
        System.out.println("Prijsberekening:");
        System.out.println("  Basis: €5.00");
        System.out.println("  Afstand: 10 km x €0.50 = €5.00");
        System.out.println("  Zwaar pakket toeslag: -");
        System.out.printf("  Totaal (via delegatie): €%.2f%n", delivery1.calculatePrice());
        System.out.println();
        
        service.addDelivery(delivery1);

        // Bezorging 2: Zwaar pakket, langere afstand
        System.out.println("--- Bezorging 2: Zwaar pakket ---");
        Address address2 = new Address("Markt", "45", "Rotterdam");
        Package package2 = new Package(15.0);  // 15 kg - zwaar!
        Delivery delivery2 = new Delivery(5.00, 25.0, package2, address2);
        
        System.out.println("Adres (via delegatie): " + delivery2.getDeliveryAddress());
        System.out.println("Pakketgewicht: " + package2.getWeight() + " kg");
        System.out.println("Package bepaalt zelf of het zwaar is: " + package2.isHeavy());
        System.out.println();
        
        System.out.println("Prijsberekening:");
        System.out.println("  Basis: €5.00");
        System.out.println("  Afstand: 25 km x €0.50 = €12.50");
        System.out.println("  Zwaar pakket toeslag (>10kg): €5.00");
        System.out.printf("  Totaal (via delegatie): €%.2f%n", delivery2.calculatePrice());
        System.out.println();
        
        service.addDelivery(delivery2);

        // Bezorging 3: Precies 10 kg (grenswaarde)
        System.out.println("--- Bezorging 3: Grenswaarde (10 kg) ---");
        Address address3 = new Address("Vredenburg", "100", "Utrecht");
        Package package3 = new Package(10.0);  // Precies 10 kg
        Delivery delivery3 = new Delivery(5.00, 15.0, package3, address3);
        
        System.out.println("Pakketgewicht: " + package3.getWeight() + " kg");
        System.out.println("Is zwaar (>10kg, niet >=10kg): " + package3.isHeavy());
        System.out.printf("Totaal: €%.2f%n", delivery3.calculatePrice());
        System.out.println();
        
        service.addDelivery(delivery3);

        // Overzicht van alle bezorgingen
        System.out.println("========================================");
        service.printAllDeliveries();

        // Delegatieketen demonstratie
        System.out.println("--- Delegatieketen ---");
        System.out.println("Prijs berekenen:");
        System.out.println("  DeliveryService → Delivery.calculatePrice()");
        System.out.println("  Delivery → Package.isHeavy()");
        System.out.println();
        System.out.println("Adres ophalen:");
        System.out.println("  Delivery → Address.getFullAddress()");
        System.out.println();
        System.out.println("De bezorgdienst controleert NOOIT zelf het gewicht!");
        System.out.println("Package is de enige die weet of het zwaar is.");
    }
}
