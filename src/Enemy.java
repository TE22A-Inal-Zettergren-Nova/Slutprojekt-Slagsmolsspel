class Enemy extends Fighter {

    // Constructor for the enemy, sets health, speed, strength, and defense based on level
    public Enemy(String name, int level) {
        super(name, 50 + level * 10, 0.8 + level * 0.2, 10 + 2 + level, 5 + level);
    }

    @Override
    public void attack(Fighter player) {
        // Calculate base damage
        int damage = strength;

        // If the player has a shield, reduce damage by the shield's defense power
        if (player.getShield() != null) {
            damage -= player.getShield().getDefensePower();
        }

        // Subtract the player's temporary defense (halved)
        damage -= (player.getTemporaryDefense() / 2);

        // Ensure the damage is not negative
        damage = Math.max(damage, 0);

        // Set a minimum damage threshold
        int minimumDamage = 5;  // Minimum damage, can be adjusted as needed, so the defence doesn't make it go to 0 damage or so
        damage = Math.max(damage, minimumDamage);

        System.out.println(name + " attacks for " + damage + " damage!");
        player.takeDamage(damage);

        // Reduce the player's temporary defense duration for the next round
        player.reduceDefenseRound();
    }

    public boolean tryDodge() {
        double dodgeChance = speed * 0.15; // Dodge chance based on the enemys speed, higher level = increasd dodge chance
        return Math.random() < dodgeChance; // Compare to random number to see if enemy dodge
    }

    @Override
    public void dodge() {
       //dosent work to use in the way that i want to because i need to return a boolean.
    }
}