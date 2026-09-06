public class VeterinaryClinic {
    private String clinicName;

    public VeterinaryClinic(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicName() {
        return clinicName;
    }

    // Delegeert volledig aan Pet; kliniek controleert NIET zelf de leeftijd
    public boolean canTreatPet(Pet pet) {
        // EDGE CASE: Geen huisdier meegegeven
        if (pet == null) {
            return false;
        }
        // Delegeer aan Pet om te vragen of eigenaar volwassen is
        return pet.hasAdultOwner();
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
        System.out.println("Huisdier: " + pet.getName() + " (" + pet.getSpecies() + ")");
        System.out.println("Eigenaar: " + getOwnerNameForPet(pet));
        System.out.println("Eigenaar volwassen (via Pet): " + pet.hasAdultOwner());
        System.out.println("Behandeling mogelijk: " + canTreatPet(pet));
    }
}
