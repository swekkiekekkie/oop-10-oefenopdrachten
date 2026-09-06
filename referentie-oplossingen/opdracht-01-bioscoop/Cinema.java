public class Cinema {
    private String name;

    public Cinema(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Cinema vraagt aan Ticket wat de opbrengst is (delegatie)
    public double calculateEarnings(Ticket ticket) {
        // EDGE CASE: Alleen geldige tickets leveren opbrengst
        if (ticket == null || !ticket.isUsed()) {
            return 0.0;
        }
        return ticket.getPrice();
    }
}
