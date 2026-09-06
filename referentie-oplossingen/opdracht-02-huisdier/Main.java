public class Main {
    public static void main(String[] args) {
        // Creëer een dierenkliniek
        VeterinaryClinic clinic = new VeterinaryClinic("Dierenkliniek De Poot");
        System.out.println("=== " + clinic.getClinicName() + " ===");
        System.out.println();

        // Scenario 1: Volwassen eigenaar
        System.out.println("--- Scenario 1: Volwassen eigenaar ---");
        Owner adultOwner = new Owner("Jan Jansen", 35);
        Pet dog = new Pet("Max", 5, 12.5, adultOwner);
        
        System.out.println("Eigenaar: " + adultOwner.getName() + ", leeftijd: " + adultOwner.getAge());
        System.out.println("Eigenaar is volwassen: " + adultOwner.isAdult());
        System.out.println();
        
        System.out.println("Huisdier: " + dog.getName() + ", " + dog.getAge() + " jaar, " + dog.getWeight() + " kg");
        System.out.println("Huisdier vraagt aan eigenaar of die volwassen is: " + dog.hasAdultOwner());
        System.out.println("Huisdier vraagt naam eigenaar: " + dog.getOwnerName());
        System.out.println();
        
        clinic.printTreatmentInfo(dog);
        System.out.println();

        // Scenario 2: Minderjarige eigenaar
        System.out.println("--- Scenario 2: Minderjarige eigenaar ---");
        Owner youngOwner = new Owner("Emma de Vries", 16);
        Pet cat = new Pet("Whiskers", 3, 4.2, youngOwner);
        
        System.out.println("Eigenaar: " + youngOwner.getName() + ", leeftijd: " + youngOwner.getAge());
        System.out.println("Eigenaar is volwassen: " + youngOwner.isAdult());
        System.out.println();
        
        System.out.println("Huisdier: " + cat.getName() + ", " + cat.getAge() + " jaar, " + cat.getWeight() + " kg");
        System.out.println("Huisdier vraagt aan eigenaar of die volwassen is: " + cat.hasAdultOwner());
        System.out.println();
        
        clinic.printTreatmentInfo(cat);
        System.out.println();

        // Demonstratie delegatieketen
        System.out.println("--- Delegatieketen demonstratie ---");
        System.out.println("Kliniek vraagt of huisdier een volwassen eigenaar heeft:");
        System.out.println("  Kliniek.hasAdultOwner(pet) → Pet.hasAdultOwner() → Owner.isAdult()");
        System.out.println("  De kliniek controleert NIET zelf de leeftijd!");
    }
}
