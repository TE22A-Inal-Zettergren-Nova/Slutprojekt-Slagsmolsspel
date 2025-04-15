class Potion extends Item {
    private String type; //Which type of potion e.g. health
    private int effectValue; //How much it gives the player e.g. 30 hp

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

            // If it's a mana potion //Kan implementeras efter mage är klar
            case "mana" -> System.out.println("Only mage uses mana.");

            // If it's a speed potion, increase the user's speed (divided by 10 to scale appropriately)
            case "speed" -> user.boostSpeed(effectValue / 10.0);

            // If it's a strength potion, increase the user's strength by effectValue
            case "strength" -> user.boostStrength(effectValue);

            // Fallback message if potion type is unknown
            default -> System.out.println("Unknown potion effect.");
        }
    }
}
