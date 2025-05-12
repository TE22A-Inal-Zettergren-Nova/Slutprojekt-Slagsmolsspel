class Weapon extends Item {
    private final int attackPower;

    public Weapon(String name, int attackPower) {
        super(name, "Weapon with " + attackPower + " attack power.");
        this.attackPower = attackPower;
    }

    @Override
    public void use(Fighter user) {
        // Implemnets weopens in other ways in the game
    }

    public int getAttackPower() {
        return attackPower;
    }
}