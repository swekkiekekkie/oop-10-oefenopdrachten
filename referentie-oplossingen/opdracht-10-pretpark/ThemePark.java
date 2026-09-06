import java.util.ArrayList;
import java.util.List;

public class ThemePark {
    private String name;
    private List<Attraction> attractions;

    public ThemePark(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void addAttraction(Attraction attraction) {
        // EDGE CASE: Null attracties niet toevoegen
        if (attraction != null) {
            attractions.add(attraction);
        }
    }

    // ThemePark.visit delegeert alle checks en acties
    public boolean visit(Ticket ticket, Attraction attraction) {
        // EDGE CASE: Geen ticket of attractie
        if (ticket == null || attraction == null) {
            System.out.println("Bezoek mislukt: ongeldige ticket of attractie");
            return false;
        }

        Visitor visitor = ticket.getVisitor();
        
        // EDGE CASE: Ticket zonder bezoeker
        if (visitor == null) {
            System.out.println("Bezoek mislukt: ticket heeft geen bezoeker");
            return false;
        }

        System.out.println("Bezoek: " + visitor.getName() + " wil naar " + attraction.getName());

        // Delegeer ticket-geldigheid aan Ticket
        if (ticket.isUsed()) {
            System.out.println("  GEBLOKKEERD: Ticket is al gebruikt");
            return false;
        }

        // Delegeer leeftijdscheck aan Attraction
        if (!attraction.allowsVisitor(visitor)) {
            System.out.println("  GEBLOKKEERD: Bezoeker is te jong (minimumleeftijd: " + 
                             attraction.getMinAge() + ", bezoeker: " + visitor.getAge() + ")");
            return false;
        }

        // Alles OK: delegeer aan Ticket om zichzelf te gebruiken
        boolean success = ticket.use();
        if (success) {
            System.out.println("  TOEGANG: Veel plezier!");
            return true;
        } else {
            System.out.println("  GEBLOKKEERD: Ticket kon niet gebruikt worden");
            return false;
        }
    }

    // Vind attracties voor een bezoeker (delegeert aan Attraction)
    public List<Attraction> findSuitableAttractions(Visitor visitor) {
        List<Attraction> suitable = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction.allowsVisitor(visitor)) {
                suitable.add(attraction);
            }
        }
        return suitable;
    }

    public void printAttractions() {
        System.out.println("=== Attracties in " + name + " ===");
        for (Attraction attraction : attractions) {
            System.out.println("- " + attraction.getName() + " (min. " + attraction.getMinAge() + " jaar)");
        }
    }
}
