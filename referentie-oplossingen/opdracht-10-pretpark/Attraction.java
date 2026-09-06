public class Attraction {
    private String name;
    private int minAge;

    public Attraction(String name, int minAge) {
        this.name = name;
        // EDGE CASE: Minimumleeftijd mag niet negatief zijn
        this.minAge = Math.max(0, minAge);
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    // Attraction weet zelf of een bezoeker oud genoeg is
    public boolean allowsVisitor(Visitor visitor) {
        // EDGE CASE: Geen bezoeker meegegeven
        if (visitor == null) {
            return false;
        }
        return visitor.getAge() >= minAge;
    }
}
