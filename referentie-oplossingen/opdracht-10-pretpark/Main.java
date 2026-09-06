public class Main {
    public static void main(String[] args) {
        // Creëer pretpark
        ThemePark park = new ThemePark("Efteling");
        
        // Voeg attracties toe
        Attraction carousel = new Attraction("Draaimolen", 0);
        Attraction python = new Attraction("Python", 10);
        Attraction baron = new Attraction("Baron 1898", 12);
        Attraction fenix = new Attraction("Fēnix", 14);
        
        park.addAttraction(carousel);
        park.addAttraction(python);
        park.addAttraction(baron);
        park.addAttraction(fenix);

        park.printAttractions();
        System.out.println();

        // Creëer bezoekers
        Visitor emma = new Visitor("Emma", 8);
        Visitor max = new Visitor("Max", 15);
        Visitor lisa = new Visitor("Lisa", 11);

        System.out.println("--- Bezoekers ---");
        System.out.println(emma.getName() + ", " + emma.getAge() + " jaar");
        System.out.println(max.getName() + ", " + max.getAge() + " jaar");
        System.out.println(lisa.getName() + ", " + lisa.getAge() + " jaar");
        System.out.println();

        // Toon geschikte attracties per bezoeker
        System.out.println("--- Geschikte attracties ---");
        System.out.println(emma.getName() + " kan naar:");
        for (Attraction a : park.findSuitableAttractions(emma)) {
            System.out.println("  - " + a.getName());
        }
        System.out.println();
        
        System.out.println(max.getName() + " kan naar:");
        for (Attraction a : park.findSuitableAttractions(max)) {
            System.out.println("  - " + a.getName());
        }
        System.out.println();

        // Koop tickets
        Ticket emmaTicket = new Ticket(35.00, emma);
        Ticket maxTicket = new Ticket(45.00, max);
        Ticket lisaTicket = new Ticket(40.00, lisa);

        System.out.println("--- Tickets ---");
        System.out.println(emmaTicket.getVisitorName() + ": €" + emmaTicket.getPrice());
        System.out.println(maxTicket.getVisitorName() + ": €" + maxTicket.getPrice());
        System.out.println(lisaTicket.getVisitorName() + ": €" + lisaTicket.getPrice());
        System.out.println();

        // Scenario 1: Kind naar kindvriendelijke attractie
        System.out.println("=== Bezoekscenario's ===");
        System.out.println();
        System.out.println("--- Scenario 1: Kind naar draaimolen ---");
        park.visit(emmaTicket, carousel);
        System.out.println();

        // Scenario 2: Tiener naar zware attractie
        System.out.println("--- Scenario 2: Tiener naar Fēnix ---");
        park.visit(maxTicket, fenix);
        System.out.println();

        // Scenario 3: Kind te jong voor attractie (EDGE CASE)
        System.out.println("--- Scenario 3: Kind te jong (EDGE CASE) ---");
        Ticket emmaTicket2 = new Ticket(35.00, emma);
        park.visit(emmaTicket2, python);
        System.out.println("(Attraction.allowsVisitor() bepaalt of bezoeker oud genoeg is)");
        System.out.println();

        // Scenario 4: Hergebruik ticket (EDGE CASE)
        System.out.println("--- Scenario 4: Ticket hergebruik (EDGE CASE) ---");
        System.out.println("Probeer zelfde ticket nogmaals te gebruiken...");
        park.visit(maxTicket, baron);
        System.out.println();

        // Lisa probeert Baron (net oud genoeg op 11, min is 12)
        System.out.println("--- Scenario 5: Grenswaarde leeftijd ---");
        System.out.println("Lisa is " + lisa.getAge() + " jaar, Baron 1898 vereist " + baron.getMinAge() + " jaar");
        park.visit(lisaTicket, baron);
        System.out.println();

        // Delegatieketen uitleg
        System.out.println("=== Delegatieketen ===");
        System.out.println("ThemePark.visit(ticket, attraction) delegeert:");
        System.out.println("  1. Ticket.isUsed() → is ticket al gebruikt?");
        System.out.println("  2. Attraction.allowsVisitor(visitor) → is bezoeker oud genoeg?");
        System.out.println("  3. Ticket.use() → markeer ticket als gebruikt");
        System.out.println();
        System.out.println("ThemePark controleert NIET zelf de leeftijd!");
        System.out.println("Attraction is verantwoordelijk voor de leeftijdscheck.");
    }
}
