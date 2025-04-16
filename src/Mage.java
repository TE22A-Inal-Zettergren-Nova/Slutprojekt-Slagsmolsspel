class Mage extends Warrior implements SpecialAbility {
    private int mana; // Mana is used to fuel the Mage's special ability

    // Constructor: initializes Mage-specific stats and equips a Staff
    public Mage(String name, Shield shield) {
        super(name, 90, 1.4, 10, 4, new Weapon("Staff", 7), shield); // Slightly less health but faster than Knight
        this.mana = 50; // Starting mana
        //Kanske lägga till lvele system som i knight och marksman??
    }

    // Implementation of the special ability (heal)
    @Override
    public void useAbility(Fighter target) {
        if (mana >= 25) { // Check if enough mana is available
            mana -= 25; // Deduct mana for using the ability
            int heal = 15;
            health += heal; // Heal self
            System.out.println(name + " heals themselves for " + heal + " HP!");
            System.out.println(mana); // Display remaining mana
            abilityCharged = mana != 0; // Only charged if mana remains
        } else {
            // Inform player they need to recharge
            System.out.println("You have no mana! Use 'Charge' to ready it.");
        }
    }

    // Recharges the Mage's ability (refills mana and sets abilityCharged)
    @Override
    public void chargeAbility() {
        System.out.println(name + " is charging their ability... Vulnerable this round!");
        abilityCharged = true;
        mana = 50; // Restore mana to full
        System.out.println(mana); // Display current mana //Justera senare mest för att se att det funkar👍
    }
}