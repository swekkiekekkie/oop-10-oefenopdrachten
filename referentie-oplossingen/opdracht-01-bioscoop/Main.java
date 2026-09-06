public class Main {
    public static void main(String[] args) {
        // Creëer een bioscoop
        Cinema cinema = new Cinema("Pathé City");
        System.out.println("Welkom bij " + cinema.getName());
        System.out.println();

        // Creëer een film
        Movie movie = new Movie("The Matrix", 136, 12.50);
        System.out.println("Film: " + movie.getTitle());
        System.out.println("Duur: " + movie.getDurationMinutes() + " minuten");
        System.out.println("Ticketprijs: €" + movie.getTicketPrice());
        System.out.println();

        // Koop een ticket
        Ticket ticket = new Ticket(15, movie);
        System.out.println("Ticket gekocht voor stoel: " + ticket.getSeatNumber());
        System.out.println("Ticket is voor film: " + ticket.getMovie().getTitle());
        System.out.println("Ticketprijs (via delegatie): €" + ticket.getPrice());
        System.out.println("Ticket gebruikt: " + ticket.isUsed());
        System.out.println();

        // Opbrengst bioscoop: dit is de verkoop, niet het gebruik
        System.out.println("--- Opbrengst bioscoop ---");
        System.out.println("Cinema vraagt aan Ticket wat de prijs is:");
        System.out.println("  Cinema → Ticket.getPrice() → Movie.getTicketPrice()");
        System.out.println("Opbrengst voor dit ticket: €" + cinema.getEarnings(ticket));
        System.out.println("(Opbrengst = verkoop, onafhankelijk van gebruik)");
        System.out.println();

        // Gebruik het ticket (toegang tot de zaal)
        System.out.println("--- Ticket gebruiken ---");
        System.out.println("Ticket gebruiken (toegang tot zaal)...");
        boolean success = ticket.use();
        System.out.println("Gebruik gelukt: " + success);
        System.out.println("Ticket nu gebruikt: " + ticket.isUsed());
        System.out.println();

        // Probeer ticket nogmaals te gebruiken (EDGE CASE)
        System.out.println("--- EDGE CASE: Ticket hergebruik ---");
        System.out.println("Probeer ticket nogmaals te gebruiken...");
        boolean secondUse = ticket.use();
        System.out.println("Tweede gebruik gelukt: " + secondUse);
        System.out.println("(Ticket kan maar één keer gebruikt worden voor toegang)");
    }
}
