public class Package {
    private double weight;

    private static final double HEAVY_THRESHOLD = 10.0;

    public Package(double weight) {
        // EDGE CASE: Gewicht mag niet negatief zijn
        this.weight = Math.max(0.0, weight);
    }

    public double getWeight() {
        return weight;
    }

    // Package weet zelf of het zwaar is (>10kg)
    public boolean isHeavy() {
        return weight > HEAVY_THRESHOLD;
    }
}
