public class Pet {
    private String name;
    private String species;
    private int age;
    private Owner owner;

    public Pet(String name, String species, int age, Owner owner) {
        this.name = name;
        this.species = species;
        // EDGE CASE: Leeftijd mag niet negatief zijn
        this.age = Math.max(0, age);
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
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
