import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private List<Booking> bookings;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        // EDGE CASE: Null kamers niet toevoegen
        if (room != null) {
            rooms.add(room);
        }
    }

    public void addBooking(Booking booking) {
        // EDGE CASE: Null boekingen niet toevoegen
        if (booking != null) {
            bookings.add(booking);
        }
    }

    // Hotel vraagt kosten aan Booking (delegatie)
    public double getBookingCost(Booking booking) {
        // EDGE CASE: Geen boeking meegegeven
        if (booking == null) {
            return 0.0;
        }
        return booking.calculateTotal();
    }

    // Vind beschikbare kamer
    public Room findAvailableRoom() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                return room;
            }
        }
        return null;
    }

    public int countAvailableRooms() {
        int count = 0;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public void printStatus() {
        System.out.println("=== " + name + " ===");
        System.out.println("Totaal kamers: " + rooms.size());
        System.out.println("Beschikbaar: " + countAvailableRooms());
        System.out.println();
        System.out.println("Kamerstatus:");
        for (Room room : rooms) {
            String status = room.isAvailable() ? "beschikbaar" : "bezet";
            System.out.printf("  Kamer %d: €%.2f/nacht (%s)%n", 
                room.getNumber(), room.getPricePerNight(), status);
        }
    }
}
