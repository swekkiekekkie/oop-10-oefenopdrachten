public class Enemy {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        // EDGE CASE: Gezondheid mag niet negatief starten
        this.health = Math.max(0, health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // Enemy beheert zijn eigen gezondheid
    public void takeDamage(int amount) {
        // EDGE CASE: Negatieve schade negeren
        if (amount < 0) {
            return;
        }
        // EDGE CASE: Gezondheid mag niet onder 0 komen
        health = Math.max(0, health - amount);
    }

    // Enemy weet zelf of hij verslagen is
    public boolean isDefeated() {
        return health <= 0;
    }
}
