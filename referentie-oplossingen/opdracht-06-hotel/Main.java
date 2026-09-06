public class Main {
    public static void main(String[] args) {
        // Creëer een hotel
        Hotel hotel = new Hotel("Grand Hotel Amsterdam");
        
        // Voeg kamers toe
        hotel.addRoom(new Room(101, 89.00));
        hotel.addRoom(new Room(102, 89.00));
        hotel.addRoom(new Room(201, 129.00));
        hotel.addRoom(new Room(202, 129.00));
        hotel.addRoom(new Room(301, 199.00));  // Suite

        // Toon beginstatus
        System.out.println("--- Beginstatus ---");
        hotel.printStatus();
        System.out.println();

        // Creëer gasten
        Guest alice = new Guest("Alice van Berg", 28);
        Guest bob = new Guest("Bob Jansen", 35);
        
        System.out.println("--- Gasten ---");
        System.out.println(alice.getName() + ", " + alice.getAge() + " jaar, volwassen: " + alice.isAdult());
        System.out.println(bob.getName() + ", " + bob.getAge() + " jaar, volwassen: " + bob.isAdult());
        System.out.println();

        // Boeking 1: Alice boekt 3 nachten
        Room room1 = hotel.findAvailableRoom();
        Booking booking1 = new Booking(3, alice, room1);
        
        System.out.println("--- Boeking 1 ---");
        System.out.println("Gast: " + booking1.getGuest().getName());
        System.out.println("Kamer: " + booking1.getRoom().getNumber());
        System.out.println("Nachten: " + booking1.getNights());
        System.out.println("Prijs per nacht: €" + booking1.getRoom().getPricePerNight());
        System.out.println("Totaal (via delegatie): €" + booking1.calculateTotal());
        System.out.println();
        
        System.out.println("Boeking uitvoeren...");
        boolean success1 = booking1.execute();
        System.out.println("Gelukt: " + success1);
        System.out.println("Kamer nu beschikbaar: " + room1.isAvailable());
        System.out.println();
        
        hotel.addBooking(booking1);

        // Boeking 2: Bob boekt de suite voor 2 nachten
        Room suite = hotel.getRooms().get(4);  // Suite kamer 301
        Booking booking2 = new Booking(2, bob, suite);
        
        System.out.println("--- Boeking 2 ---");
        System.out.println("Gast: " + booking2.getGuest().getName());
        System.out.println("Kamer: " + booking2.getRoom().getNumber());
        System.out.println("Nachten: " + booking2.getNights());
        System.out.println();
        
        System.out.println("Hotel vraagt kosten aan Booking:");
        System.out.println("  Hotel → Booking.calculateTotal() → Room.getPricePerNight()");
        System.out.println("  Kosten: €" + hotel.getBookingCost(booking2));
        System.out.println();
        
        booking2.execute();
        hotel.addBooking(booking2);

        // EDGE CASE: Probeer nogmaals dezelfde kamer te boeken
        System.out.println("--- EDGE CASE: Dubbele boeking ---");
        Booking duplicateBooking = new Booking(1, alice, room1);
        boolean duplicateSuccess = duplicateBooking.execute();
        System.out.println("Dubbele boeking gelukt: " + duplicateSuccess);
        System.out.println("(Kamer was al bezet)");
        System.out.println();

        // Eindstatus
        System.out.println("--- Eindstatus ---");
        hotel.printStatus();
    }
}
