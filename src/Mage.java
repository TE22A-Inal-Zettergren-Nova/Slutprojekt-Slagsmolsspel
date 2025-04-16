class Mage extends Warrior implements SpecialAbility {
    private int mana; // Mana is used to fuel the Mage's special ability

    // Constructor: initializes Mage-specific stats and equips a Staff
    public Mage(String name, Shield shield) {
        super(name, 90, 1.4, 10, 4, new Weapon("Staff", 8), shield, 1); // Slightly less health but faster than Knight
        this.mana = 40; // Starting mana
        this.strength = strength + level; //increses their strenght with one after each level
    }

    // Implementation of the special ability (heal)
    @Override
    public void useAbility(Fighter target) {
        if (mana >= 20) { // Check if enough mana is available
            mana -= 20; // Deduct mana for using the ability
            int heal = 30;
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

    // Method to restore mana, via mana potion
    public void restoreMana(int amount) {
        this.mana += amount;
        System.out.println(name + "'s mana is now " + mana + ".");
    }

    //returns current value of mana
    public int getMana() {
        return mana;
    }
}