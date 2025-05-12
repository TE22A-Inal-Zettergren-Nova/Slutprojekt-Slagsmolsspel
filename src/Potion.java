class Potion extends Item {
    private final String type; //Which type of potion e.g. health
    private final int effectValue; //How much it gives the player e.g. 30 hp

    //Constructor for potion
    public Potion(String name, String description, String type, int effectValue) {
        super(name, description);
        this.type = type;
        this.effectValue = effectValue;
    }

    @Override
    public void use(Fighter user) {
        // Applies the potion effect based on its type
        switch (type) {
            // If it's a health potion, heal the user by effectValue
            case "health" -> user.heal(effectValue);

            // If it's a mana potion and the user is a Mage
            case "mana" -> {
                if (user instanceof Mage mageUser) {
                    // Cast the user to a Mage to access their mana
                    mageUser.restoreMana(effectValue); // Restore mana for the Mage
                    System.out.println("\u001b[36m"+ mageUser.getName() + " restores " + effectValue + " mana!\u001B[0m");
                } else {
                    System.out.println("Only mages can use mana potions!");
                }
            }

            // If it's a speed potion, increase the user's speed (divided by 10 to scale appropriately)
            case "speed" -> user.boostSpeed(effectValue / 10.0);

            // If it's a strength potion, increase the user's strength by effectValue
            case "strength" -> user.boostStrength(effectValue);

            // Fallback message if potion type is unknown
            default -> System.out.println("Unknown potion effect.");
        }
    }
}
