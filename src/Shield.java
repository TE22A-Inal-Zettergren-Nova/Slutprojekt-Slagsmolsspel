// The Shield class grants temporary defense when used.
class Shield extends Item {

    // The amount of defense power the shield provides when used
    private final int defensePower;

    // Constructor for the Shield class, taking a name and the defense power
    public Shield(String name, int defensePower) {
        super(name, "Shield with " + defensePower + " defense power."); //Generated description

        this.defensePower = defensePower;
    }

    // When the shield is used by a Fighter, it grants temporary defense for 3 rounds
    @Override
    public void use(Fighter user) {
        System.out.println(user.getName() + " uses " + name + " to raise a shield.");
        // Applies the shield's defense power for 3 rounds
        user.addTemporaryDefense(defensePower, 3);
    }

    // Getter for the defense power of the shield
    public int getDefensePower() {
        return defensePower;
    }
}