public class Pet {
    private String name;
    private int age;
    private double weight;
    private Owner owner;

    public Pet(String name, int age, double weight, Owner owner) {
        this.name = name;
        // EDGE CASE: Leeftijd mag niet negatief zijn
        this.age = Math.max(0, age);
        // EDGE CASE: Gewicht mag niet negatief zijn
        this.weight = Math.max(0.0, weight);
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public Owner getOwner() {
        return owner;
    }

    // Delegeert de volwassen-vraag aan Owner
    public boolean hasAdultOwner() {
        // EDGE CASE: Huisdier zonder eigenaar
        if (owner == null) {
            return false;
        }
        return owner.isAdult();
    }

    // Delegeert de naam-vraag aan Owner
    public String getOwnerName() {
        // EDGE CASE: Huisdier zonder eigenaar
        if (owner == null) {
            return "Onbekend";
        }
        return owner.getName();
    }
}
