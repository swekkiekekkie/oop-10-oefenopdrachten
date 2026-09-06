public class Ticket {
    private double price;
    private boolean used;
    private Visitor visitor;

    public Ticket(double price, Visitor visitor) {
        // EDGE CASE: Prijs mag niet negatief zijn
        this.price = Math.max(0.0, price);
        this.used = false;
        this.visitor = visitor;
    }

    public double getPrice() {
        return price;
    }

    public boolean isUsed() {
        return used;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    // Ticket markeert zichzelf als gebruikt
    public boolean use() {
        // EDGE CASE: Al gebruikt
        if (used) {
            return false;
        }
        used = true;
        return true;
    }

    // Delegeert bezoekersinformatie
    public String getVisitorName() {
        // EDGE CASE: Geen bezoeker gekoppeld
        if (visitor == null) {
            return "Onbekend";
        }
        return visitor.getName();
    }

    public int getVisitorAge() {
        // EDGE CASE: Geen bezoeker gekoppeld
        if (visitor == null) {
            return 0;
        }
        return visitor.getAge();
    }
}
