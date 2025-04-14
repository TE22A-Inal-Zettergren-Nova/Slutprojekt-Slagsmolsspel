class Shield extends Item {
    private final int defensePower;

    public Shield(String name, int defensePower) {
        super(name, "Shield with " + defensePower + " defense power.");
        this.defensePower = defensePower;
    }

    @Override
    public void use(Fighter user) {
        System.out.println(user.getName() + " uses " + name + " to raise a shield.");
        user.addTemporaryDefense(defensePower, 3); // 3 rundor

    }

    public int getDefensePower() {
        return defensePower;
    }
}

