public class Booking {
    private int nights;
    private Guest guest;
    private Room room;
    private boolean executed;

    public Booking(int nights, Guest guest, Room room) {
        // EDGE CASE: Minimaal 1 nacht
        this.nights = Math.max(1, nights);
        this.guest = guest;
        this.room = room;
        this.executed = false;
    }

    public int getNights() {
        return nights;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isExecuted() {
        return executed;
    }

    // Booking berekent totaal door prijs aan Room te vragen
    public double calculateTotal() {
        // EDGE CASE: Geen kamer gekoppeld
        if (room == null) {
            return 0.0;
        }
        return nights * room.getPricePerNight();
    }

    // Alias: getTotalPrice voor PDF-stijl
    public double getTotalPrice() {
        return calculateTotal();
    }

    // Booking voert zichzelf uit en markeert kamer als bezet
    public boolean execute() {
        // EDGE CASE: Al uitgevoerd
        if (executed) {
            return false;
        }
        // EDGE CASE: Geen kamer of gast
        if (room == null || guest == null) {
            return false;
        }
        // EDGE CASE: Kamer niet beschikbaar
        if (!room.isAvailable()) {
            return false;
        }
        
        // Delegeer aan Room om zichzelf als bezet te markeren
        room.markAsBooked();
        executed = true;
        return true;
    }
}
