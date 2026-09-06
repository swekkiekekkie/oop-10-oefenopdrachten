public class VeterinaryClinic {
    private String clinicName;

    public VeterinaryClinic(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicName() {
        return clinicName;
    }

    // Vraagt of een huisdier een volwassen eigenaar heeft (delegeert via Pet→Owner)
    // Dit is de PDF-vereiste methode
    public boolean hasAdultOwner(Pet pet) {
        // EDGE CASE: Geen huisdier meegegeven
        if (pet == null) {
            return false;
        }
        // Delegeer aan Pet om te vragen of eigenaar volwassen is
        return pet.hasAdultOwner();
    }

    // Alias: kan behandelen als eigenaar volwassen is
    public boolean canTreatPet(Pet pet) {
        return hasAdultOwner(pet);
    }

    // Delegeert aan Pet voor eigenaarsnaam
    public String getOwnerNameForPet(Pet pet) {
        // EDGE CASE: Geen huisdier meegegeven
        if (pet == null) {
            return "Onbekend";
        }
        return pet.getOwnerName();
    }

    // Geeft informatie over behandeling via delegatie
    public void printTreatmentInfo(Pet pet) {
        System.out.println("Kliniek: " + clinicName);
        if (pet == null) {
            System.out.println("Geen huisdier opgegeven.");
            return;
        }
        System.out.println("Huisdier: " + pet.getName() + ", " + pet.getAge() + " jaar, " + pet.getWeight() + " kg");
        System.out.println("Eigenaar: " + getOwnerNameForPet(pet));
        System.out.println("Eigenaar volwassen (via Pet): " + hasAdultOwner(pet));
        System.out.println("Behandeling mogelijk: " + canTreatPet(pet));
    }
}
