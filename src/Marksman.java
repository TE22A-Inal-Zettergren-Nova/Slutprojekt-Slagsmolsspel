class Marksman extends Warrior implements SpecialAbility {

    // Constructor: initializes Marksman-specific stats and equips a Bow
    public Marksman(String name, Shield shield) {
        super(name, 100, 1.7, 12, 6, new Weapon("Bow", 9), shield,1);
        this.level ++;
        this.strength = strength + level; //increses their strenght with one after each level
    }

    // Implementation of the special ability (Fire Arrow) //Kanske ändra systemet men funkar som detta oxå
    @Override
    public void useAbility(Fighter target) {
        if (abilityCharged) { // Ability can only be used if charged
            // Calculates damage using strength, weapon power, bonus, and level
            int fireArrow = strength + weapon.getAttackPower() + 6 + level;
            System.out.println("\u001b[32m" + name + " uses Fire Arrow!\u001B[0m");
            target.takeDamage(fireArrow); // Deal the calculated damage to the target
            abilityCharged = false; // Ability must be recharged before next use
        } else {
            // Inform player that ability is not ready
            System.out.println("\u001b[34m Ability not charged! Use 'Charge' to ready it.\u001B[0m");
        }
    }

}