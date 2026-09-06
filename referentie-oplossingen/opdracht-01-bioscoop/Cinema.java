public class Cinema {
    private String name;

    public Cinema(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Cinema vraagt aan Ticket wat de opbrengst is (delegatie)
    // Opbrengst = verkoop van ticket, niet het gebruik ervan
    public double getEarnings(Ticket ticket) {
        // EDGE CASE: Geen ticket meegegeven
        if (ticket == null) {
            return 0.0;
        }
        // Delegeer aan Ticket voor de prijs (die weer delegeert aan Movie)
        return ticket.getPrice();
    }

    // Alias voor getEarnings
    public double calculateEarnings(Ticket ticket) {
        return getEarnings(ticket);
    }
}
