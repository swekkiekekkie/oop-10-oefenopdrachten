public class Main {
    public static void main(String[] args) {
        // Creëer een wapen
        Weapon sword = new Weapon("Excalibur", 25);
        System.out.println("Wapen gecreëerd: " + sword.getName());
        System.out.println("Schade: " + sword.getDamage());
        System.out.println();

        // Creëer een speler met het wapen
        Player player = new Player("Ridder Arthur", 100, sword);
        System.out.println("Speler: " + player.getName());
        System.out.println("Gezondheid: " + player.getHealth());
        System.out.println("Wapen: " + player.getWeapon().getName());
        System.out.println();

        // Creëer een vijand
        Enemy dragon = new Enemy("Draak Smaug", 80);
        System.out.println("Vijand: " + dragon.getName());
        System.out.println("Gezondheid: " + dragon.getHealth());
        System.out.println("Verslagen: " + dragon.isDefeated());
        System.out.println();

        // Gevecht simulatie
        System.out.println("=== Gevecht begint ===");
        int round = 1;
        while (!dragon.isDefeated()) {
            System.out.println("Ronde " + round + ":");
            System.out.println("  " + player.getName() + " valt aan met " + player.getWeapon().getName());
            player.attack(dragon);
            System.out.println("  " + dragon.getName() + " heeft nog " + dragon.getHealth() + " gezondheid");
            System.out.println("  Vijand verslagen: " + dragon.isDefeated());
            System.out.println();
            round++;
        }

        System.out.println("=== Gevecht voorbij ===");
        System.out.println(player.getName() + " heeft " + dragon.getName() + " verslagen!");
        System.out.println();

        // Demonstreer EDGE CASE: aanvallen na verslagen
        System.out.println("--- EDGE CASE: Aanval na verslagen ---");
        int healthBefore = dragon.getHealth();
        player.attack(dragon);
        System.out.println("Gezondheid draak voor extra aanval: " + healthBefore);
        System.out.println("Gezondheid draak na extra aanval: " + dragon.getHealth());
        System.out.println("(Aanval wordt genegeerd want vijand is al verslagen)");
    }
}
